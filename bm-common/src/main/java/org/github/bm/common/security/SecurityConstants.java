package org.github.bm.common.security;

public interface SecurityConstants {

    /**
     * 客户端请求认证头
     */
    String AUTH_HEADER_KEY = "Authorization";
    /**
     * 认证信息Key
     */
    String CONTEXT_HOLDER_USER_KEY = "BM-Authorization-User";

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
     * 网关透传用户ID
     */
    String GATEWAY_AUTHORIZATION_ID_KEY = GATEWAY_AUTHORIZATION_KEY + "-id";

    //================================== 内部调用认证 End

    interface JwtConstants {
        String PAYLOAD_ID = "id";
    }
}
