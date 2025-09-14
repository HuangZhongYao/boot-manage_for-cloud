package org.github.bm.websocket.service;

import org.github.bm.websocket.base.WebSocketMessage;
import org.github.bm.websocket.dto.NotificationMessagePayloadDTO;
import org.github.bm.websocket.dto.PublicNotificationMessagePayloadDTO;

/**
 * Time 2025-09-08 14:37
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
public interface IWebSocketService {
    /**
     * 发送通知消息 , 指定用户
     * @param message 消息体
     * @return  发送成功数
     */
    Integer sendNotificationMessage(WebSocketMessage<NotificationMessagePayloadDTO> message);

    /**
     * 公共通知消息全部用户都会收到
     * @param message 消息体
     * @return 发送成功数
     */
    Integer sendPublicNotificationMessage(WebSocketMessage<PublicNotificationMessagePayloadDTO> message);
}
