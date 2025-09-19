package org.github.bm.websocket.service.strategy;

import org.github.bm.websocket.base.MessageHandlerConstant;
import org.springframework.stereotype.Component;

/**
 * 公告通知处理策略
 * Time 2025-09-08 14:58
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Component(MessageHandlerConstant.NOTIFICATION_HANDLER_NAME)
public class WebSocketMessageNotificationHandlerStrategy implements WebSocketMessageHandlerStrategy {

    /**
     * 处理WebSocket消息的方法
     *
     * @param message WebSocket消息内容
     * @return 成功处理的通知记录数量
     */
    @Override
    public Integer handle(String message) {

        return 0;
    }
}
