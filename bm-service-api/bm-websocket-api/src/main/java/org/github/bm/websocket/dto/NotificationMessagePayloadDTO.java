package org.github.bm.websocket.dto;

import lombok.*;
import org.github.bm.system.enums.NotificationsLevelEnum;
import org.github.bm.system.enums.NotificationsRecordBusinessTypeEnum;
import org.github.bm.websocket.base.AbstractPayload;

import java.time.LocalDateTime;

/**
 * 通知消息负载类
 */
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationMessagePayloadDTO extends AbstractPayload {

    /**
     * 通知公告内容
     */
    private String content;

    /**
     * 公告通知发布时间
     */
    private LocalDateTime publishTime;

    /**
     * 通知业务场景
     */
    private NotificationsRecordBusinessTypeEnum businessType;

    /**
     * 通知业务场景关联业务Id
     */
    private Long businessId;

    /**
     * 通知级别
     */
    private NotificationsLevelEnum level;

}
