package org.github.bm.websocket.config;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.github.bm.base.prop.SecurityProperties;
import org.github.bm.base.security.SecurityConstants;
import org.github.bm.websocket.base.SimpConstant;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.messaging.AbstractSubProtocolEvent;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;


/**
 * WebSocket握手拦截器
 */
@Slf4j
@Component
public class AuthHandshakeInterceptor  implements HandshakeInterceptor {
    @Resource
    SecurityProperties securityProperties = new SecurityProperties();

    /**
     * WebSocket握手前的认证处理方法
     * 在WebSocket连接建立之前验证用户身份，如果验证通过则允许连接并存储用户信息
     *
     * @param request    WebSocket握手请求对象
     * @param response   WebSocket握手响应对象
     * @param wsHandler  WebSocket处理器
     * @param attributes 用于存储连接属性的Map对象
     * @return 验证通过返回true允许连接，验证失败返回false拒绝连接
     * @throws Exception 验证过程中可能抛出的异常
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        // 从请求参数中获取token
        if (request instanceof ServletServerHttpRequest servletRequest) {
            // 获取请求参数中的token
            String accessToken = servletRequest.getServletRequest().getParameter(SecurityConstants.AUTH_HEADER_KEY);
            if (accessToken == null) {
                // 如果请求参数中没有token则从请求头中获取
                accessToken = servletRequest.getHeaders().getFirst(SecurityConstants.AUTH_HEADER_KEY);
            }
            if (accessToken != null && validateToken(accessToken)) {
                // 将用户信息存储到attributes中
                String userId = getUserIdFromToken(accessToken);
                if (userId != null) {
                    attributes.put(SimpConstant.SIMP_USER_KEY, userId);
                    attributes.put(SimpConstant.SIMP_AUTHENTICATED_KEY, true);
                    request.getHeaders().add(SimpConstant.SIMP_USER_KEY, userId);
                    log.info("握手成功，用户ID已存储: {}", userId);
                } else {
                    log.info("握手失败，无法从Token中提取用户ID");
                    return false;
                }
                return true;
            } else {
                log.warn("握手失败，token验证失败或为空，token: {}", accessToken);
            }
        } else {
            log.warn("请求类型不匹配: {}", request.getClass().getName());
        }
        // 验证失败，拒绝连接
        return false;
    }


    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
        // 握手后处理
    }

    private boolean validateToken(String token) {
        // 实现JWT token验证逻辑
        try {
            //  令牌前缀验证
            if (!token.startsWith(SecurityConstants.AUTH_HEADER_PREFIX)) {
                return false;
            }
            // 验证令牌有效性
            token = token.substring(SecurityConstants.AUTH_HEADER_PREFIX.length());
            if (!JWTUtil.verify(token, securityProperties.getToken().getSecret().getBytes())) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String getUserIdFromToken(String token) {
        try {
            token = token.substring(SecurityConstants.AUTH_HEADER_PREFIX.length());
            // 解析令牌
            JWT jwt = JWTUtil.parseToken(token);
            // 获取令牌payload
            Object authUserId = jwt.getPayload(SecurityConstants.JwtConstants.PAYLOAD_AUTHORIZATION_USER_ID);
            return authUserId.toString();
        } catch (Exception e) {
            return null;
        }
    }

    // 辅助方法：安全地从事件中获取会话ID
    private String getSessionIdFromEvent(AbstractSubProtocolEvent event) {
        Object sessionId = event.getMessage().getHeaders().get(SimpConstant.SIMP_SESSION_ID_KEY);
        return sessionId != null ? sessionId.toString() : null;
    }
}
