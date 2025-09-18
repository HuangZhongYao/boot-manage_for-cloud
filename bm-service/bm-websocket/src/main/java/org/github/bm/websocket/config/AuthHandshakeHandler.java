package org.github.bm.websocket.config;

import lombok.extern.slf4j.Slf4j;
import org.github.bm.websocket.base.SimpConstant;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;


/**
 * WebSocket握手拦截器
 */
@Slf4j
@Component
public class AuthHandshakeHandler extends DefaultHandshakeHandler {
    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler,
                                      Map<String, Object> attributes) {
        return StompPrincipal
                .builder()
                .name(attributes.getOrDefault(SimpConstant.SIMP_USER_KEY, "").toString())
                .publicName(request.getRemoteAddress().getAddress().getHostName())
                .build();
    }

}
