package org.github.bm.websocket.service;

import org.github.bm.websocket.base.WebSocketMessage;
import org.github.bm.websocket.dto.NotificationMessagePayloadDTO;

/**
 * Time 2025-09-08 14:37
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
public interface IWebSocketService {
    /**
     * 发送通知公告消息
     * @param message 消息体
     * @return  发送成功数
     */
    Integer sendNotificationMessage(WebSocketMessage<NotificationMessagePayloadDTO> message);
}
