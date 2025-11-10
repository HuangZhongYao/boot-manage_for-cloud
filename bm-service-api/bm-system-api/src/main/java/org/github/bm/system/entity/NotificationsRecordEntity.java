package org.github.bm.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.github.bm.common.base.entity.AbstractIdAndTimeEntity;
import org.github.bm.system.enums.NotificationsLevelEnum;
import org.github.bm.system.enums.NotificationsRecordBusinessTypeEnum;

import java.time.LocalDateTime;

/**
 * 通知记录表实体
 * Time 2025-08-28 16:26
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_notifications_record")
public class NotificationsRecordEntity extends AbstractIdAndTimeEntity {

    /**
     * 通知内容表id {@link NotificationsRecordContentEntity#id}
     */
    private Long contentId;

    /**
     * 用户id {@link UserEntity#id}
     */
    private Long userId;

    /**
     * 读取状态
     */
    private Boolean readState;

    /**
     * 阅读时间
     */
    private LocalDateTime readTime;

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
