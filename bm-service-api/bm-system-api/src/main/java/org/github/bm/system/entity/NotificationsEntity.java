package org.github.bm.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.github.bm.common.base.entity.AbstractBaseEntity;
import org.github.bm.system.enums.NotificationsStateEnum;

import java.time.LocalDateTime;

/**
 * 通知表实体
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
     * 撤回时间
     */
    private LocalDateTime revokeTime;
}
