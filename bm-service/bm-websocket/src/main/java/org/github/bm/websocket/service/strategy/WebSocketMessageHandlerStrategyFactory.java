package org.github.bm.websocket.service.strategy;

import org.github.bm.websocket.base.MessageHandlerConstant;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 策略工厂
 * Time 2025-09-08 15:29
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Component
public class WebSocketMessageHandlerStrategyFactory {
    /**
     * 策略集合
     */
    private final Map<String, WebSocketMessageHandlerStrategy> strategys;

    public WebSocketMessageHandlerStrategyFactory(Map<String, WebSocketMessageHandlerStrategy> strategys) {
        this.strategys = strategys;
    }

    /**
     * 根据名称获取WebSocket消息处理策略
     *
     * @param name WebSocket消息处理策略的名称
     * @return 返回对应的WebSocket消息处理策略对象，如果名称不存在则默认策略
     */
    public WebSocketMessageHandlerStrategy getStrategy(String name) {
        return strategys.getOrDefault(name, strategys.get(MessageHandlerConstant.DEFAULT_HANDLER_NAME));
    }
}
