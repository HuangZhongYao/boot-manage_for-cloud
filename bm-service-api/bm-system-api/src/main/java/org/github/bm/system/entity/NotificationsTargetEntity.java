package org.github.bm.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.github.bm.base.base.entity.AbstractIdAndTimeEntity;
import org.github.bm.system.enums.NotificationsTargetEnum;

/**
 * 通知目标实体表
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
@TableName("sys_notifications_target")
public class NotificationsTargetEntity extends AbstractIdAndTimeEntity {

    /**
     * NotificationsEntity 主表 id {@link NotificationsEntity#id}
     */
    private Long notificationsId;

    /**
     * 通知目标类型
     */
    private NotificationsTargetEnum targetType;

    /**
     * 通知目标Id
     */
    private Long targetId;

    /**
     * 通知目标名称
     */
    private String targetName;
}
