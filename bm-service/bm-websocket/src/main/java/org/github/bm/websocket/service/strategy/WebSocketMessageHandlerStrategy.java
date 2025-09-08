package org.github.bm.websocket.service.strategy;

import org.github.bm.websocket.base.WebSocketMessage;

/**
 * 消息处理策略接口
 * Time 2025-09-08 14:49
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
public interface WebSocketMessageHandlerStrategy {
    /**
     * 处理消息
     *
     * @param message 消息体
     * @return 处理结果
     */
    Integer handle(String message);
}
