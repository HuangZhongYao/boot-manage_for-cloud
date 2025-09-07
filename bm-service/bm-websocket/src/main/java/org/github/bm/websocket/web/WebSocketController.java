package org.github.bm.websocket.web;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.annotation.Resource;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

@Hidden
@Controller
public class WebSocketController {

    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message sendMessage(Message message) {
        // 处理消息并广播
        return message;
    }

    @MessageMapping("/private")
    public void sendPrivateMessage(@Payload Message message, StompHeaderAccessor headerAccessor) {
        // 发送私人消息
        simpMessagingTemplate.convertAndSendToUser(
                "user",
                "/queue/messages",
                message
        );
    }


}
