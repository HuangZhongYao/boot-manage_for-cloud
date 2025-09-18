package org.github.bm.websocket.config;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.github.bm.websocket.base.SimpConstant;
import org.github.bm.websocket.service.IOnlineUserService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocket客户端状态监听
 *
 * @author Tony Peng
 * @date 2022/10/27 11:19
 */
@Slf4j
@Component
public class WebSocketEventListener {

    @Resource
    IOnlineUserService onlineUserService;

    /**
     * 监听客户端连接请求（握手阶段）
     */
    @EventListener
    public void handleWebSocketConnectListener(SessionConnectEvent event) {
        String userId = getUserIdFromEvent(event);
        String sessionId = getSessionIdFromEvent(event);

        if (userId != null) {
            onlineUserService.addOnlineUser(userId);
            log.info("WebSocket 客户端正在连接: 用户ID={}, 会话ID={}", userId, sessionId);
        } else {
            log.warn("WebSocket 客户端正在连接但未获取到用户信息，会话ID={}", sessionId);
        }
    }

    /**
     * 监听客户端关闭事件
     */
    @EventListener
    public void handleWebSocketCloseListener(SessionDisconnectEvent event) {
        String userId = getUserIdFromEvent(event);
        String sessionId = getSessionIdFromEvent(event);

        if (userId != null) {
            onlineUserService.removeOnlineUser(userId);
            log.info("WebSocket 客户端已关闭: 用户ID={}, 会话ID={}", userId, sessionId);
        } else {
            log.warn("WebSocket 客户端已关闭但未获取到用户信息，会话ID={}", sessionId);
        }
    }

    /**
     * 监听客户端订阅事件
     */
    @EventListener
    public void handleSubscription(SessionSubscribeEvent event) {
        String userId = getUserIdFromEvent(event);
        String sessionId = getSessionIdFromEvent(event);
        String destination = getDestinationFromEvent(event);

        if (userId != null) {
            log.info("WebSocket 客户端已订阅: 用户ID={}, 订阅节点={}, 会话ID={}", userId, destination, sessionId);
        } else {
            log.warn("WebSocket 客户端已订阅但未获取到用户信息，订阅节点={}, 会话ID={}", destination, sessionId);
        }
    }

    /**
     * 监听客户端取消订阅事件
     */
    @EventListener
    public void handleUnSubscription(SessionUnsubscribeEvent event) {
        String userId = getUserIdFromEvent(event);
        String sessionId = getSessionIdFromEvent(event);
        String destination = getDestinationFromEvent(event);

        if (userId != null) {
            log.info("WebSocket 客户端已取消订阅: 用户ID={}, 取消订阅节点={}, 会话ID={}", userId, destination, sessionId);
        } else {
            log.warn("WebSocket 客户端已取消订阅但未获取到用户信息，取消订阅节点={}, 会话ID={}", destination, sessionId);
        }
    }

    // 辅助方法：安全地从事件中获取用户ID
    private String getUserIdFromEvent(AbstractSubProtocolEvent event) {
        // 获取Principal
        if (event.getUser() != null) {
            return event.getUser().getName();
        }
        // 从消息头中获取
        Map simpSessionAttributes = event.getMessage().getHeaders().get("simpSessionAttributes", Map.class);
        if (simpSessionAttributes == null) {
            return null;
        }
        Object userId = simpSessionAttributes.get(SimpConstant.SIMP_USER_KEY);
        return userId == null ? null : userId.toString();
    }

    // 辅助方法：安全地从事件中获取会话ID
    private String getSessionIdFromEvent(AbstractSubProtocolEvent event) {
        Object sessionId = event.getMessage().getHeaders().get(SimpConstant.SIMP_SESSION_ID_KEY);
        return sessionId != null ? sessionId.toString() : "unknown";
    }

    // 辅助方法：安全地从事件中获取订阅目标
    private String getDestinationFromEvent(AbstractSubProtocolEvent event) {
        Object destination = event.getMessage().getHeaders().get("simpDestination");
        return destination != null ? destination.toString() : "unknown";
    }
}

