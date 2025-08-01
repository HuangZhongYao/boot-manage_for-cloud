package org.github.bm.common.security;

import java.util.List;

public interface SecurityConstants {

    /**
     * 客户端请求令牌头
     */
    String AUTH_HEADER_KEY = "BM-Authorization";
    /**
     * 刷新令牌头
     */
    String REFRESH_AUTH_HEADER_KEY = "BM-Refresh-Authorization";
    /**
     * 认证信息Key
     */
    String CONTEXT_HOLDER_USER_KEY = "BM-Authorization-User";

    /**
     * 默认排除的URL 不进行鉴权
     */
    List<String> DEFAULT_EXCLUDE_PATTERNS = List.of(
            "/actuator/**",
            "/actuator/health/**",
            "/v2/api-docs/**",
            "/v3/api-docs/**",
            "/auth/login",
            "/auth/loginOut",
            "/doc.html/**",
            "/error/**",
            "/assets/**"
    );

    //================================== 内部调用认证 Begin
    /**
     * 调用源
     */
    String REQUEST_SOURCE = "X-Request-Source";
    /**
     * 网关认证前缀
     */
    String GATEWAY_AUTHORIZATION_PREFIX = "X-Gateway-";
    /**
     * 网关认证key
     */
    String GATEWAY_AUTHORIZATION_KEY = GATEWAY_AUTHORIZATION_PREFIX + "Authorization";
    /**
     * 网关透传请求上下文信息KEY
     */
    String GATEWAY_AUTHORIZATION_CONTEXT_HOLDER_KEY = GATEWAY_AUTHORIZATION_KEY + "-ContextHolder";

    //================================== 内部调用认证 End

    /**
     * 生成jwt令牌常量
     */
    interface JwtConstants {
        String PAYLOAD_AUTHORIZATION_USER = "payload-authorization";
    }
}
