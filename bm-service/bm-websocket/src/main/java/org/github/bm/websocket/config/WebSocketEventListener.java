package org.github.bm.websocket.config;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.github.bm.websocket.service.IOnlineUserService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;
import org.springframework.web.socket.messaging.SessionUnsubscribeEvent;

import static cn.hutool.json.JSONUtil.toBean;
import static cn.hutool.json.JSONUtil.toJsonStr;
import static java.util.Objects.requireNonNull;

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
     * 监听客户端连接
     *
     * @param event 连接事件对象
     */
    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        StompPrincipal principal = toBean(toJsonStr(event.getUser()), StompPrincipal.class);
        log.info("WebSocket 客户端已连接: {}",
                "{ 客户端主机名: " + principal.getName() +
                        ", 客户端主机IP地址: " + principal.getPublicName() +
                        ", 会话ID: " + requireNonNull(event.getMessage().getHeaders().get("simpSessionId")) + " }");
    }

    /**
     * 监听客户端关闭事件
     *
     * @param event 关闭事件对象
     */
    @EventListener
    public void handleWebSocketCloseListener(SessionDisconnectEvent event) {
        StompPrincipal principal = toBean(toJsonStr(event.getUser()), StompPrincipal.class);
        log.info("WebSocket 客户端已关闭: {}",
                "{ 客户端主机名: " + principal.getName() +
                        ", 客户端主机IP地址: " + principal.getPublicName() +
                        ", 会话ID: " + requireNonNull(event.getMessage().getHeaders().get("simpSessionId")) + " }");
    }

    /**
     * 监听客户端订阅事件
     *
     * @param event 订阅事件对象
     */
    @EventListener
    public void handleSubscription(SessionSubscribeEvent event) {
        StompPrincipal principal = toBean(toJsonStr(event.getUser()), StompPrincipal.class);
        log.info("WebSocket 客户端已订阅: {}",
                "{ 客户端主机名: " + principal.getName() +
                        ", 客户端主机IP地址: " + principal.getPublicName() +
                        ", 订阅节点: " + requireNonNull(event.getMessage().getHeaders().get("simpDestination")) + " }");
    }

    /**
     * 监听客户端取消订阅事件
     *
     * @param event 取消订阅事件对象
     */
    @EventListener
    public void handleUnSubscription(SessionUnsubscribeEvent event) {
        StompPrincipal principal = toBean(toJsonStr(event.getUser()), StompPrincipal.class);
        log.info("WebSocket 客户端已取消订阅: {}",
                "{ 客户端主机名: " + principal.getName() +
                        ", 客户端主机IP地址: " + principal.getPublicName() +
                        ", 取消订阅节点: " + requireNonNull(event.getMessage().getHeaders().get("simpDestination")) + " }");
    }
}
