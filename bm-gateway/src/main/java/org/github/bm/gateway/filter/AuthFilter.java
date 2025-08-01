
package org.github.bm.gateway.filter;

import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.alibaba.fastjson2.JSON;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.github.bm.common.base.response.ErrorResponse;
import org.github.bm.common.enums.ServiceEnum;
import org.github.bm.common.prop.SecurityProperties;
import org.github.bm.common.security.SecurityConstants;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;


@Slf4j
@Component
public class AuthFilter implements GlobalFilter, Ordered {
	@Resource
	SecurityProperties securityProperties = new SecurityProperties();
	AntPathMatcher matcher = new AntPathMatcher();

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// 获取请求路径
		String path = exchange.getRequest().getURI().getPath();
		// 是否是放行路径
		if (isSkip(path)) {
			return chain.filter(exchange);
		}
		// 获取响应对象
		ServerHttpResponse response = exchange.getResponse();
		// 获取令牌
		String headerToken = exchange.getRequest().getHeaders().getFirst(SecurityConstants.AUTH_HEADER_KEY);
		String paramToken = exchange.getRequest().getQueryParams().getFirst(SecurityConstants.AUTH_HEADER_KEY);
		String token = StrUtil.isNotBlank(headerToken) ? headerToken : paramToken;

		if (StrUtil.isAllBlank(headerToken, paramToken)) {
			return this.error(response, path, "缺失令牌,鉴权失败");
		}
		// 验证令牌
		if (!JWTUtil.verify(token, securityProperties.getToken().getSecret().getBytes())) {
			return this.error(response, path, "令牌验证失败");
		}

		// 解析令牌
		JWT jwt = JWTUtil.parseToken(headerToken);
		Object payload = jwt.getPayload(SecurityConstants.JwtConstants.PAYLOAD_ID);

		// 透传header给下游服务
		exchange.getRequest()
				.mutate()
				.header(SecurityConstants.GATEWAY_AUTHORIZATION_ID_KEY, payload.toString())
				.header(SecurityConstants.REQUEST_SOURCE, ServiceEnum.APPLICATION_GATEWAY.name)
				.header(SecurityConstants.GATEWAY_AUTHORIZATION_KEY, securityProperties.getInternalValid().getToken())
				.build();

		return chain.filter(exchange);
	}

	private Mono<Void> error(ServerHttpResponse response, String path, String msg) {
		response.setStatusCode(HttpStatus.UNAUTHORIZED);
		response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		String result = JSON.toJSONString(new ErrorResponse(msg, path, false));
		DataBuffer buffer = response.bufferFactory().wrap(result.getBytes(StandardCharsets.UTF_8));
		return response.writeWith(Flux.just(buffer));
	}

	private boolean isSkip(String path) {
		return securityProperties.getSkipUrl().stream().anyMatch(skipUrl -> matcher.match(skipUrl, path));
	}


	@Override
	public int getOrder() {
		return Integer.MIN_VALUE;
	}

}
