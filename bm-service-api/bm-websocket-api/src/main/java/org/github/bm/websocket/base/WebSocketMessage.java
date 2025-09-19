package org.github.bm.websocket.base;

import lombok.*;
import org.github.bm.common.base.dto.BaseDTO;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.util.Map;

/**
 * Time 2025-09-08 10:17
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode(callSuper = false)
public class WebSocketMessage<T extends AbstractPayload> extends BaseDTO implements Message<T> {

    /**
     * 消息处理器 MessageHandlerConstant 中定义
     */
    private String handlerName = MessageHandlerConstant.DEFAULT_HANDLER_NAME;

    /**
     * 消息载体
     */
    private T payload;

    /**
     * 消息头
     */
    private MessageHeaders headers;

    public WebSocketMessage() {
    }

    public WebSocketMessage(T payload) {
        this.payload = payload;
        this.headers = new MessageHeaders(null);
    }

    public WebSocketMessage(String handlerName, T payload) {
        this.handlerName = handlerName;
        this.payload = payload;
    }

    public WebSocketMessage(T payload, MessageHeaders headers) {
        this.payload = payload;
        this.headers = headers;
    }

    public WebSocketMessage(String handlerName, T payload, MessageHeaders headers) {
        this.handlerName = handlerName;
        this.payload = payload;
        this.headers = headers;
    }

    public static <T extends AbstractPayload> WebSocketMessage<T> build(T payload) {
        return new WebSocketMessage<>(payload);
    }

    public static <T extends AbstractPayload> WebSocketMessage<T> build(T payload, Map<String, Object> headers) {
        return new WebSocketMessage<>(payload, new MessageHeaders(headers));
    }

}
