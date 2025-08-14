
package org.github.bm.gateway.filter;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.NumberWithFormat;
import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.RegisteredPayload;
import com.alibaba.fastjson2.JSON;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.github.bm.common.base.response.ErrorResponse;
import org.github.bm.common.base.response.ResponseCode;
import org.github.bm.common.constant.RedisConstant;
import org.github.bm.common.constant.ServiceEnum;
import org.github.bm.common.enums.ClientEnum;
import org.github.bm.common.prop.SecurityProperties;
import org.github.bm.common.security.SecurityConstants;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
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
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Component
public class AuthFilter implements GlobalFilter, Ordered {
	@Resource
	SecurityProperties securityProperties = new SecurityProperties();
	@Resource
	RedisTemplate<String,String> redisTemplate;
	AntPathMatcher matcher = new AntPathMatcher();

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// 获取请求路径
		String path = exchange.getRequest().getURI().getPath();
		// 是否是放行路径
		if (isSkip(path)) {
			//
			exchange.getRequest()
					.mutate()
					.header(SecurityConstants.REQUEST_SOURCE_PATH, path)
					.build();
			return chain.filter(exchange);
		}
		// 获取响应对象
		ServerHttpResponse response = exchange.getResponse();
		// 获取令牌
		String headerToken = exchange.getRequest().getHeaders().getFirst(SecurityConstants.AUTH_HEADER_KEY);
		String paramToken = exchange.getRequest().getQueryParams().getFirst(SecurityConstants.AUTH_HEADER_KEY);
		String token = StrUtil.isNotBlank(headerToken) ? headerToken : paramToken;
		// 验证是否携带令牌
		if (StrUtil.isAllBlank(headerToken, paramToken)) {
			return this.error(response, path, "缺失令牌,鉴权失败", ResponseCode.REQUEST_FAILED.code);
		}
		// 验证令牌有效性
		token = token.substring(securityProperties.getToken().getPrefix().length());
		if (!JWTUtil.verify(token, securityProperties.getToken().getSecret().getBytes())) {
			return this.error(response, path, "令牌验证失败", ResponseCode.REQUEST_FAILED.code);
		}
		// 解析令牌
		JWT jwt = JWTUtil.parseToken(token);
		// 获取令牌payload中用户信息
		String authUser = (String) jwt.getPayload(SecurityConstants.JwtConstants.PAYLOAD_AUTHORIZATION_USER);
		Object authUserId =  jwt.getPayload(SecurityConstants.JwtConstants.PAYLOAD_AUTHORIZATION_USER_ID);
		// 验证令牌是否过期
		if (checkExpires(authUserId,token)) {
			return this.error(response, path, "令牌已过期", ResponseCode.LOGIN_EXPIRED.code);
		}

		// 透传请求上下文信息给下游服务
		exchange.getRequest()
				.mutate()
				.header(SecurityConstants.REQUEST_SOURCE_PATH, path)
				.header(SecurityConstants.GATEWAY_AUTHORIZATION_CONTEXT_HOLDER_KEY, authUser)
				.header(SecurityConstants.GATEWAY_AUTHORIZATION_CONTEXT_USER_ID_HOLDER_KEY, authUserId.toString())
				.header(SecurityConstants.REQUEST_SOURCE, ServiceEnum.APPLICATION_GATEWAY.name)
				.header(SecurityConstants.GATEWAY_AUTHORIZATION_KEY, securityProperties.getInternalValid().getToken())
				.build();

		return chain.filter(exchange);
	}

	/**
	 * 检查token是否过期
	 * @param authUserId 用户ID
	 * @param token 令牌
	 * @return true:过期
	 */
	private boolean checkExpires(Object  authUserId,String token) {
		ArrayList<String> tokenKeys = new ArrayList<>(6);
		for (ClientEnum clientEnum : ClientEnum.values()) {
			tokenKeys.add(RedisConstant.Authorization.clientAuthorizationCacheKey(clientEnum)+ authUserId.toString());
		}
		// 获取redis中令牌
		List<String> authorizationTokenList = redisTemplate.opsForValue().multiGet(tokenKeys);
		// 获取不到认为过期
		if(CollectionUtil.isEmpty(authorizationTokenList)) return true;
		// 与redis中令牌一致认为未过期
		for (String authorizationToken : authorizationTokenList) {
            if (StrUtil.isNotBlank(authorizationToken) && StrUtil.equalsAny(authorizationToken,true, token)) {
                return false;
            }
		}
		return true;
	}

	private Mono<Void> error(ServerHttpResponse response, String path, String msg, int code) {
		response.setStatusCode(HttpStatus.OK);
		response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		String result = JSON.toJSONString(new ErrorResponse(code, msg, path, false));
		DataBuffer buffer = response.bufferFactory().wrap(result.getBytes(StandardCharsets.UTF_8));
		return response.writeWith(Flux.just(buffer));
	}

	private boolean isSkip(String path) {
		return SecurityConstants.DEFAULT_EXCLUDE_PATTERNS
				.stream()
				.anyMatch(skipUrl -> matcher.match(skipUrl, path))
				||
				securityProperties.getSkipUrl()
						.stream()
						.anyMatch(skipUrl -> matcher.match(skipUrl, path));
	}


	@Override
	public int getOrder() {
		return Integer.MIN_VALUE;
	}

}
