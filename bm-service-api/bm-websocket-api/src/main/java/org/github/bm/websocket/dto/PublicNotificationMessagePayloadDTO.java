package org.github.bm.websocket.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.github.bm.system.enums.NotificationsLevelEnum;
import org.github.bm.system.enums.NotificationsTypeEnum;
import org.github.bm.websocket.base.AbstractPayload;

/**
 * 公共通知消息全部用户都会收到
 */
@Setter
@Getter
@ToString
public class PublicNotificationMessagePayloadDTO extends AbstractPayload {
    /**
     * 通知公告Id
     * NotificationsEntity#id {@link org.github.bm.system.entity.NotificationsEntity#id}
     */
    private Long notificationsId;

    /**
     * 通知公告内容
     */
    private String content;

    /**
     * 公告通知发布时间
     */
    private LocalDateTime publishTime;

    /**
     * 通知类型
     */
    private NotificationsTypeEnum type;

    /**
     * 通知级别
     */
    private NotificationsLevelEnum level;

}
