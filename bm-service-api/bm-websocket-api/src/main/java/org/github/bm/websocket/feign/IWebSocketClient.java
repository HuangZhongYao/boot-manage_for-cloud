package org.github.bm.websocket.feign;

import org.github.bm.common.base.fegin.BaseFeign;
import org.github.bm.common.constant.AppConstant;
import org.github.bm.websocket.base.WebSocketMessage;
import org.github.bm.websocket.dto.NotificationMessagePayloadDTO;
import org.github.bm.websocket.feign.fallback.WebSocketClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Time 2025-09-08 09:51
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@FeignClient(value = AppConstant.APPLICATION_WEBSOCKET_NAME, contextId = "webSocketClient", fallback = WebSocketClientFallback.class)
public interface IWebSocketClient extends BaseFeign {
    /**
     * WebSocket服务API路径前缀
     */
    String API_PREFIX = BASE_API_PREFIX + "/websocket";

    /**
     * 发送公告通知消息path
     */
    String SEND_NOTIFICATION_MESSAGE = API_PREFIX + "/sendNotificationMessage";

    /**
     * 发送公告通知消息path
     */
    String SEND_PUBLIC_NOTIFICATION_MESSAGE = API_PREFIX + "/sendPublicNotificationMessage";

    /**
     * 发送公告通知消息,通知指定用户
     *
     * @param message 包含消息载体的对象
     * @return 发送成功数
     */
    @PostMapping(SEND_NOTIFICATION_MESSAGE)
    Integer sendNotificationMessage(@RequestBody WebSocketMessage<NotificationMessagePayloadDTO> message);

    /**
     * 发送广播公告通知消息,通知全体用户
     *
     * @param message 包含消息载体的对象
     * @return 发送成功数
     */
    @PostMapping(SEND_PUBLIC_NOTIFICATION_MESSAGE)
    Integer sendPublicNotificationMessage(@RequestBody WebSocketMessage<NotificationMessagePayloadDTO> message);
}
