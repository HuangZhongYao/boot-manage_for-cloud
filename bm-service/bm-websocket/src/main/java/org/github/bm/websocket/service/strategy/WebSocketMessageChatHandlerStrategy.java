package org.github.bm.websocket.service.strategy;

import org.github.bm.websocket.base.MessageHandlerConstant;
import org.springframework.stereotype.Component;

/**
 * 聊天消息处理器可以进行聊天记录保存等操作
 * Time 2025-09-08 14:58
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Component(MessageHandlerConstant.DEFAULT_HANDLER_NAME)
public class WebSocketMessageChatHandlerStrategy implements WebSocketMessageHandlerStrategy {
    @Override
    public Integer handle(String message) {
        // TODO 待扩展聊天功能，例如聊天记录保存等操作
        return 0;
    }
}
