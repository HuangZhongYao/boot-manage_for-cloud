package org.github.bm.websocket.service.strategy;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import org.github.bm.system.entity.NotificationsRecordEntity;
import org.github.bm.websocket.base.MessageHandlerConstant;
import org.github.bm.websocket.base.WebSocketMessage;
import org.github.bm.websocket.dto.NotificationMessagePayloadDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 公告通知处理策略，将公告消息入库到通知记录表
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
        // 解析消息内容，并转换为NotificationMessagePayloadDTO对象
        WebSocketMessage<NotificationMessagePayloadDTO> webSocketMessage = JSON.parseObject(message, new TypeReference<WebSocketMessage<NotificationMessagePayloadDTO>>() {
        });
        // 消息载体
        NotificationMessagePayloadDTO payload = webSocketMessage.getPayload();
        // 如果没有接收人，则不处理
        if (payload == null || payload.getTo() == null || payload.getTo().isEmpty()) {
            return 0;
        }

        // 创建通知记录实体列表，并为每个接收者创建一个记录
        List<NotificationsRecordEntity> notificationsRecordEntityList = new ArrayList<>(payload.getTo().size());
        // 遍历接收者列表，创建通知记录实体，并设置相关属性
        for (String userId : payload.getTo()) {
            NotificationsRecordEntity notificationRecordEntity = new NotificationsRecordEntity();
            notificationRecordEntity.setUserId(Long.valueOf(userId));
            notificationRecordEntity.setNotificationsId(payload.getNotificationsId());
            notificationRecordEntity.setReadState(Boolean.FALSE);
            notificationRecordEntity.setType(payload.getType());
            notificationRecordEntity.setLevel(payload.getLevel());
            notificationsRecordEntityList.add(notificationRecordEntity);
        }
        // 调用存储方法，将通知记录实体列表保存到数据库
        return notificationsRecordEntityList.size();
    }
}
