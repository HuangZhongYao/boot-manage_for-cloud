package org.github.bm.websocket.config;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;


/**
 * WebSocket握手拦截器
 */
@Component
public class AuthHandshakeInterceptor implements HandshakeInterceptor {
    
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        
        // 从请求参数中获取token
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            String token = servletRequest.getServletRequest().getParameter("token");
            
            if (token != null && validateToken(token)) {
                // 将用户信息存储到attributes中
                String username = getUsernameFromToken(token);
                attributes.put("username", username);
                attributes.put("authenticated", true);
                return true;
            }
        }
        
        return false; // 验证失败，拒绝连接
    }
    
    @Override
    public void afterHandshake(ServerHttpRequest request, 
                              ServerHttpResponse response, 
                              WebSocketHandler wsHandler, 
                              Exception exception) {
        // 握手后处理
    }
    
    private boolean validateToken(String token) {
        // 实现JWT token验证逻辑
        try {
            // 使用JWT库验证token
            // JWTVerifier verifier = JWT.require(algorithm).build();
            // verifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    private String getUsernameFromToken(String token) {
        // 从token中提取用户名
        // DecodedJWT jwt = JWT.decode(token);
        // return jwt.getSubject();
        return "username";
    }
}
