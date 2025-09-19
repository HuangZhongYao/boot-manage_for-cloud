package org.github.bm.websocket.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson2.JSON;
import jakarta.annotation.Resource;
import org.github.bm.user.feign.IUserClient;
import org.github.bm.websocket.base.SimpConstant;
import org.github.bm.websocket.base.WebSocketMessage;
import org.github.bm.websocket.dto.NotificationMessagePayloadDTO;
import org.github.bm.websocket.service.IOnlineUserService;
import org.github.bm.websocket.service.IWebSocketService;
import org.github.bm.websocket.service.strategy.WebSocketMessageHandlerStrategy;
import org.github.bm.websocket.service.strategy.WebSocketMessageHandlerStrategyFactory;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * Time 2025-09-08 14:37
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Service
public class WebSocketServiceImpl implements IWebSocketService {
    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;
    @Resource
    private WebSocketMessageHandlerStrategyFactory webSocketMessageHandlerStrategyFactory;
    @Resource
    private IUserClient userClient;
    @Resource
    private IOnlineUserService onlineUserService;

    @Override
    public Integer sendNotificationMessage(
            WebSocketMessage<NotificationMessagePayloadDTO> message) {
        NotificationMessagePayloadDTO payload = message.getPayload();
        // 发送目标为空则不执行
        if (CollectionUtil.isEmpty(payload.getTo())) {
            return 0;
        }
        // 遍历用户推送通知 TODO 可以优化成遍历在线用户
//        for (String userId : payload.getTo()) {
//            simpMessagingTemplate.convertAndSendToUser(userId,
//                SimpConstant.Queue.USER_QUEUE_MESSAGES, message);
//        }
        // 获取所有在线用户
        for (Long userId : onlineUserService.getOnlineUserIdList()) {
            simpMessagingTemplate.convertAndSendToUser(String.valueOf(userId),
                    SimpConstant.Queue.USER_QUEUE_MESSAGES, message);
        }
        // 获取消息处理策略
        WebSocketMessageHandlerStrategy handlerStrategy =
                webSocketMessageHandlerStrategyFactory.getStrategy(message.getHandlerName());
        //
        handlerStrategy.handle(JSON.toJSONString(message));
        return payload.getTo().size();
    }

    @Override
    public Integer sendPublicNotificationMessage(
            WebSocketMessage<NotificationMessagePayloadDTO> message) {
        // 推送消息
        simpMessagingTemplate.convertAndSend(SimpConstant.Topic.NOTIFICATIONS_TOPIC, message);
        // 获取消息处理策略
        WebSocketMessageHandlerStrategy handlerStrategy =
                webSocketMessageHandlerStrategyFactory.getStrategy(message.getHandlerName());
        // 处理消息
        handlerStrategy.handle(JSON.toJSONString(message));
        return message.getPayload().getTo().size();
    }
}
