package org.github.bm.base.security;

import org.github.bm.base.prop.SecurityProperties;
import org.springframework.util.AntPathMatcher;

import java.util.List;

public interface SecurityConstants {
    /**
     * 客户端请求令牌前缀
     */
    String AUTH_HEADER_PREFIX = "Bearer ";
    /**
     * 客户端请求令牌头name
     */
    String AUTH_HEADER_KEY = "BM-Authorization";
    /**
     * 刷新令牌头name
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

    /**
     * AntPathMatcher
     */
    AntPathMatcher MATCHER = new AntPathMatcher();

    /**
     * 默认排除的URL不进行鉴权 , 请根据业务情况自行修改
     */
    List<String> DEFAULT_EXCLUDE_PATTERNS = List.of(
            "/auth/login",
            "/auth/loginOut",
            "/auth/refreshToken",
            "/bm-websocket/ws/**", // 放行websocket
            "/ws/**", // 放行websocket
            "/actuator/**",
            "/doc.html/**",
            "/error/**",
            "/assets/**",
            "/static/**",
            "/public/**",
            "/META-INF/resources/**",
            "/css/**",
            "/js/**",
            "/images/**",
            "/webjars/**",
            "/localStorage/**"// 使用本地存储放行请求
    );

    /**
     * 是否是跳过鉴权
     *
     * @param isGateway          是否请求来自网关转发
     * @param path               请求路径
     * @param originalPath       请求原始路径  （调用 /bm-auth/auth/login 登录，登录中调用用户服务/bm-user/user/getById获取用户. /bm-auth/auth/login 就是/bm-user/user/getById的原始路径  ）
     * @param securityProperties 项目安全配置属性
     * @return true: 跳过鉴权
     */
    static boolean isSkip(boolean isGateway, String path, String originalPath, SecurityProperties securityProperties) {
        if (isGateway) {
            // 配置中心配置的跳过鉴权url集合
            List<String> skipUrls = securityProperties.getSkipUrl();
            // 匹配配置中心跳过鉴权url
            if (skipUrls.stream().anyMatch(pattern -> MATCHER.match(pattern, path))) {
                return true;
            }
            // 去除第一级服务名路径
            String removeFirstLevelPath = path.replaceAll("^/[^/]+/", "/");
            // 匹配默认跳过鉴权url
            return SecurityConstants.DEFAULT_EXCLUDE_PATTERNS.stream().anyMatch(pattern -> MATCHER.match(pattern, removeFirstLevelPath));
        } else {
            // 当前路径匹配默认跳过鉴权url
            if (SecurityConstants.DEFAULT_EXCLUDE_PATTERNS.stream().anyMatch(pattern -> MATCHER.match(pattern, path))) {
                return true;
            }
            // 配置中心配置的跳过鉴权url集合
            List<String> skipUrls = securityProperties.getSkipUrl();
            // 原始路径匹配配置中心跳过鉴权url
            return skipUrls.stream().anyMatch(pattern -> MATCHER.match(pattern, originalPath));
        }
    }
}
