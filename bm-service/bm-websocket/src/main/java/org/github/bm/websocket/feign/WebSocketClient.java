package org.github.bm.websocket.feign;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.annotation.Resource;
import org.github.bm.websocket.base.WebSocketMessage;
import org.github.bm.websocket.dto.NotificationMessagePayloadDTO;
import org.github.bm.websocket.service.IWebSocketService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Time 2025-09-08 14:34
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Hidden
@RestController
public class WebSocketClient implements IWebSocketClient{

    @Resource
    private IWebSocketService webSocketService;
    @Override
    @PostMapping(SEND_NOTIFICATION_MESSAGE)
    public Integer sendNotificationMessage(@RequestBody WebSocketMessage<NotificationMessagePayloadDTO> message) {
        return webSocketService.sendNotificationMessage(message);
    }

    @Override
    @PostMapping(SEND_PUBLIC_NOTIFICATION_MESSAGE)
    public Integer sendPublicNotificationMessage(WebSocketMessage<NotificationMessagePayloadDTO> message) {
        return webSocketService.sendPublicNotificationMessage( message);
    }
}
