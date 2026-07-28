package org.github.bm.websocket.base;

import lombok.*;
import org.github.bm.base.base.dto.BaseDTO;

import java.time.LocalDateTime;
import java.util.List;

/**
 * WebSocket消息负载的抽象基类
 * <p>
 * 该类定义了WebSocket消息负载的基本属性，包括消息的发送方、接收方、时间戳和处理器类型。
 * 所有具体的WebSocket消息负载类都应该继承此类。
 * </p>
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractPayload extends BaseDTO {
    public static final String DEFAULT_FROM = "-1";
    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息发送方标识; 发送方id  -1为系统发送
     */
    private String from;

    /**
     * 消息接收方标识; id列表
     */
    private List<Long> to;

    /**
     * 消息发送时间
     */
    private LocalDateTime time;
}
