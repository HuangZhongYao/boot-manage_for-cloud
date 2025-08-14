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
     * 认证信息用户ID Key
     */
    String CONTEXT_HOLDER_USER_ID_KEY = "BM-Authorization-UserId";

    String BM_CLIENT_TYPE = "BM-Client-Type";

    /**
     * 默认排除的URL 不进行鉴权
     */
    List<String> DEFAULT_EXCLUDE_PATTERNS = List.of(
            "/actuator/**",
            "/actuator/health/**",
            "/v2/api-docs/**",
            "/v3/api-docs/**",
            "/auth/login",
            "/auth/refreshToken",
            "/doc.html/**",
            "/error/**",
            "/assets/**"
    );

    //================================== 内部调用认证 Begin
    /**
     * 网关认证前缀
     */
    String BASE_GATEWAY_AUTHORIZATION_PREFIX = "BM-Gateway-";
    /**
     * 调用源
     */
    String REQUEST_SOURCE = BASE_GATEWAY_AUTHORIZATION_PREFIX + "Request-Source";
    /**
     * 调用源路径
     */
    String REQUEST_SOURCE_PATH = BASE_GATEWAY_AUTHORIZATION_PREFIX + "Request-Source-Path";
    /**
     * 网关认证key
     */
    String GATEWAY_AUTHORIZATION_KEY = BASE_GATEWAY_AUTHORIZATION_PREFIX + "Authorization";
    /**
     * 网关透传请求上下文信息KEY
     */
    String GATEWAY_AUTHORIZATION_CONTEXT_HOLDER_KEY = GATEWAY_AUTHORIZATION_KEY + "-ContextHolder";
    /**
     * 网关透传请求上下文用户Id KEY
     */
    String GATEWAY_AUTHORIZATION_CONTEXT_USER_ID_HOLDER_KEY = GATEWAY_AUTHORIZATION_KEY + "-ContextHolder-UserId";

    //================================== 内部调用认证 End

    /**
     * 生成jwt令牌常量
     */
    interface JwtConstants {

        /**
         * 认证用户信息在jwt PAYLOAD 中的KEY
         */
        String PAYLOAD_AUTHORIZATION_USER = "payload-authorization";

        /**
         * 认证用户ID信息在jwt PAYLOAD 中的KEY
         */
        String PAYLOAD_AUTHORIZATION_USER_ID = "payload-authorization-id";

    }
}
