package org.github.bm.websocket.service.strategy;

import org.github.bm.websocket.base.MessageHandlerConstant;
import org.springframework.stereotype.Component;

/**
 * 默认消息处理器
 * Time 2025-09-08 14:58
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Component(MessageHandlerConstant.DEFAULT_HANDLER_NAME)
public class WebSocketMessageDefaultHandlerStrategy implements WebSocketMessageHandlerStrategy {
    @Override
    public Integer handle(String message) {
        // 默认消息处理器不进行处理
        return 0;
    }
}
