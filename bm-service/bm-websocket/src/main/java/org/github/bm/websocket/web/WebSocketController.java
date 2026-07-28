package org.github.bm.websocket.web;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson2.JSON;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.annotation.Resource;
import org.github.bm.base.base.response.ApiResponse;
import org.github.bm.websocket.base.SimpConstant;
import org.github.bm.websocket.base.WebSocketMessage;
import org.github.bm.websocket.dto.NotificationMessagePayloadDTO;
import org.github.bm.websocket.service.strategy.WebSocketMessageHandlerStrategy;
import org.github.bm.websocket.service.strategy.WebSocketMessageHandlerStrategyFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;

@Controller
public class WebSocketController {

    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;
    @Resource
    private WebSocketMessageHandlerStrategyFactory webSocketMessageHandlerStrategyFactory;

    @Operation(summary = "测试发送广播消息")
    @GetMapping("/testSendTopic")
    @ResponseBody
    public ApiResponse<Boolean> testSendTopic(@RequestParam("message") String message) {
        simpMessagingTemplate.convertAndSend(SimpConstant.Topic.NOTIFICATIONS_TOPIC,
                "服务器发送测试广播消息:" + message);
        return ApiResponse.ok(true);
    }

    @Operation(summary = "测试发送用户消息")
    @GetMapping("/testSendToUser")
    @ResponseBody
    public ApiResponse<Boolean> testSendToUser(@RequestParam("message") String message,
                                               @Parameter(description = "用户id",example = "1,2,3") @RequestParam("userIds") String[] userIds) {
        for (String userId : userIds) {
            simpMessagingTemplate.convertAndSendToUser(userId, SimpConstant.Queue.USER_QUEUE_MESSAGES, "服务器发送测试消息" + message);
        }
        return ApiResponse.ok(true);
    }

    /**
     * 测试广播通知消息
     *
     * @param message 消息
     * @return Message
     */
    @MessageMapping("/testNotificationsMessages") // @MessageMapping 将方法映射为消息处理方法
    @SendTo(SimpConstant.Topic.TEST_TOPIC) // @SendTo 将方法返回值发送到指定的主题
    public Message<Object> testSendMessage(Message<Object> message) {
        // 处理消息并广播
        return message;
    }

    /**
     * 广播通知消息, 发送通知消息给全体用户
     *
     * @param message 消息
     * @return Message
     */
    @MessageMapping("/sendNotificationsMessagesToAll")
    @SendTo(SimpConstant.Topic.NOTIFICATIONS_TOPIC) // @SendTo 将方法返回值发送到指定的主题
    public Message<NotificationMessagePayloadDTO> sendMessage(WebSocketMessage<NotificationMessagePayloadDTO> message) {
        // 处理消息并广播
        WebSocketMessageHandlerStrategy handlerStrategy =
                webSocketMessageHandlerStrategyFactory.getStrategy(message.getHandlerName());
        handlerStrategy.handle(JSON.toJSONString(message));
        return message;
    }

    /**
     * 通知消息, 发送通知消息给指定用户
     *
     * @param principal      用户
     * @param message        消息
     * @param headerAccessor 头信息
     */
    @MessageMapping("/sendNotificationsMessagesToUser")
    public void sendPrivateMessage(Principal principal, @Payload WebSocketMessage<NotificationMessagePayloadDTO> message, StompHeaderAccessor headerAccessor) {
        // payload
        NotificationMessagePayloadDTO payload = message.getPayload();
        // 接收消息的目标用户
        List<Long> payloadTo = payload.getTo();
        // 如果接收用户为空，则不处理
        if (CollectionUtil.isEmpty(payloadTo)) {
            return;
        }
        for (Long userId : payloadTo) {
            // 发送用户消息
            simpMessagingTemplate.convertAndSendToUser(
                    String.valueOf(userId),
                    SimpConstant.Queue.USER_QUEUE_MESSAGES,
                    message
            );
        }
    }


}
