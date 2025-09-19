package org.github.bm.websocket.base;

/**
 * websocket 消息处理器常量
 * Time 2025-09-08 11:29
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
public interface MessageHandlerConstant {

    /**
     * 默认处理器
     */
    String DEFAULT_HANDLER_NAME = "webSocketMessageDefaultHandler";
    /**
     * 通知消息处理器
     */
    String NOTIFICATION_HANDLER_NAME = "webSocketMessageNotificationHandler";
    /**
     * 聊天消息处理器
     */
    String CHAT_HANDLER_NAME = "webSocketMessageChatHandler";
}
