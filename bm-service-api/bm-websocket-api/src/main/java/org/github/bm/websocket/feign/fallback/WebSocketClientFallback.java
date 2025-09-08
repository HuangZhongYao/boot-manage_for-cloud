package org.github.bm.websocket.feign.fallback;

import org.github.bm.websocket.base.WebSocketMessage;
import org.github.bm.websocket.dto.NotificationMessagePayloadDTO;
import org.github.bm.websocket.feign.IWebSocketClient;
import org.springframework.stereotype.Component;

/**
 * Time 2025-09-08 09:56
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Component
public class WebSocketClientFallback implements IWebSocketClient {
    @Override
    public Integer sendNotificationMessage(WebSocketMessage<NotificationMessagePayloadDTO> message) {
        return 0;
    }
}
