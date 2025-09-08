package org.github.bm.websocket.service.impl;

import org.github.bm.websocket.base.WebSocketMessage;
import org.github.bm.websocket.dto.NotificationMessagePayloadDTO;
import org.github.bm.websocket.service.IWebSocketService;
import org.springframework.stereotype.Service;

/**
 * Time 2025-09-08 14:37
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Service
public class WebSocketServiceImpl implements IWebSocketService {
    @Override
    public Integer sendNotificationMessage(WebSocketMessage<NotificationMessagePayloadDTO> message) {
        return 0;
    }
}
