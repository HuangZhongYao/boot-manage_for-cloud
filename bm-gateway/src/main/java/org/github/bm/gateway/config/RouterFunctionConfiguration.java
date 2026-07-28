package org.github.bm.gateway.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.github.bm.base.constant.ServiceEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * 路由配置信息
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
@AllArgsConstructor
public class RouterFunctionConfiguration {

    /**
     * 这里为支持的请求头，根据情况添加
     */
    private static final String ALLOWED_HEADERS = "X-Requested-With, Tenant-Id, Client-ID, BM-Authorization, BM-Refresh-Authorization, BM-Authorization-User, BM-Authorization-UserId, BM-Client-Type, Request-Source, Content-Type, Authorization, credential, X-XSRF-TOKEN, X-Token, token, username, client, knfie4j-gateway-request, request-origion, upgrade";
    private static final String ALLOWED_METHODS = "GET,POST,PUT,PATCH,DELETE,OPTIONS,HEAD,TRACE,CONNECT";
    private static final String ALLOWED_ORIGIN = "*";
    private static final String ALLOWED_EXPOSE = "*";
    private static final String MAX_AGE = "18000L";

    /**
     * 跨域配置
     */
    @Bean
    public WebFilter corsFilter() {
        return (ServerWebExchange ctx, WebFilterChain chain) -> {
            ServerHttpRequest request = ctx.getRequest();
            // 对WebSocket路径不应用网关的CORS规则
            String path = request.getURI().getPath();
            if (path.contains(ServiceEnum.APPLICATION_WEBSOCKET.name)) {
                return chain.filter(ctx);
            }
            if (CorsUtils.isCorsRequest(request)) {
                ServerHttpResponse response = ctx.getResponse();
                HttpHeaders headers = response.getHeaders();
                headers.add("Access-Control-Allow-Headers", ALLOWED_HEADERS);
                headers.add("Access-Control-Allow-Methods", ALLOWED_METHODS);
                headers.add("Access-Control-Allow-Origin", ALLOWED_ORIGIN);
                headers.add("Access-Control-Expose-Headers", ALLOWED_EXPOSE);
                headers.add("Access-Control-Max-Age", MAX_AGE);
                headers.add("Access-Control-Allow-Credentials", "true");// 和 Access-Control-Allow-Origin = * 有冲突
                if (request.getMethod() == HttpMethod.OPTIONS) {
                    response.setStatusCode(HttpStatus.OK);
                    return Mono.empty();
                }
            }
            return chain.filter(ctx);
        };
    }

}
