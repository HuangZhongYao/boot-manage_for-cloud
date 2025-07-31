
package org.github.bm.gateway.filter;

import com.alibaba.nacos.common.utils.StringUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.github.bm.common.security.SecurityConstants;
import org.github.bm.common.prop.SecurityProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Slf4j
@Component
public class AuthFilter implements GlobalFilter, Ordered {
	@Resource
	SecurityProperties securityProperties;

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		String path = exchange.getRequest().getURI().getPath();
		if (isSkip(path)) {
			return chain.filter(exchange);
		}
		ServerHttpResponse resp = exchange.getResponse();
		String headerToken = exchange.getRequest().getHeaders().getFirst(SecurityConstants.AUTH_HEADER);
		String paramToken = exchange.getRequest().getQueryParams().getFirst(SecurityConstants.AUTH_HEADER);
		if (StringUtils.isBlank(headerToken) && StringUtils.isBlank(paramToken)) {
			log.error("缺失令牌,鉴权失败");
		}
		log.info("headerToken: {},paramToken: {}", headerToken, paramToken);

		return chain.filter(exchange);
	}

	private boolean isSkip(String path) {
		return securityProperties.getSkipUrl().contains(path);
	}


	@Override
	public int getOrder() {
		return -100;
	}

}
