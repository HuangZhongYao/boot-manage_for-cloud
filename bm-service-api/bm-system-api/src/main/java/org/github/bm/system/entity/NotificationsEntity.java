package org.github.bm.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.github.bm.common.base.entity.AbstractBaseEntity;
import org.github.bm.system.enums.NotificationsLevelEnum;
import org.github.bm.system.enums.NotificationsStateEnum;
import org.github.bm.system.enums.NotificationsTypeEnum;

import java.time.LocalDateTime;

/**
 * 公告通知表实体
 * Time 2025-08-28 16:08
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_notifications")
public class NotificationsEntity extends AbstractBaseEntity {
    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 状态
     */
    private NotificationsStateEnum state;

    /**
     * 发布时间
     */
    private LocalDateTime publishTime;

    /**
     * 发布人
     */
    private Long publisher;

    /**
     * 撤回时间
     */
    private LocalDateTime revokeTime;

    /**
     * 通知类型
     */
    private NotificationsTypeEnum type;

    /**
     * 通知级别
     */
    private NotificationsLevelEnum level;

    /**
     * 是否全体通知
     */
    private Boolean allNotifications;
}
