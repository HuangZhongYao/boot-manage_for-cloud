package org.github.bm.websocket.web;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.github.bm.websocket.base.SimpConstant;
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

@Controller
public class WebSocketController {

    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;

    @Operation(summary = "测试发送广播消息")
    @GetMapping("/testSendTopic")
    @ResponseBody
    public Object testSendTopic(@RequestParam("message") String message) {
        simpMessagingTemplate.convertAndSend(SimpConstant.TOPIC_PREFIX + "/testNotificationsMessages","Server message:" + message);
        return "Server message:" + message;
    }

    /**
     * 测试广播通知消息
     *
     * @param message 消息
     * @return Message
     */
    @MessageMapping("/testNotificationsMessages") // @MessageMapping 将方法映射为消息处理方法
    @SendTo(SimpConstant.TOPIC_PREFIX + "/testNotificationsMessages") // @SendTo 将方法返回值发送到指定的主题
    public Message testSendMessage(Message message) {
        // 处理消息并广播
        return message;
    }

    /**
     * 广播通知消息
     *
     * @param message
     * @return
     */
    @MessageMapping("/notificationsMessages")
    @SendTo(SimpConstant.TOPIC_PREFIX + "/notificationsMessages")
    public Message sendMessage(Message message) {
        // 处理消息并广播
        return message;
    }

    @MessageMapping("/private")
    public void sendPrivateMessage(@Payload Message message, StompHeaderAccessor headerAccessor) {
        // 发送私人消息
        simpMessagingTemplate.convertAndSendToUser(
                "user",
                SimpConstant.QUEUE_PREFIX + "/messages",
                message
        );
    }


}
