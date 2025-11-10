package org.github.bm.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.github.bm.common.base.entity.AbstractIdAndTimeEntity;

/**
 * 通知记录通知内容表实体
 * Time 2025-11-10 14:21
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_notifications_record_content")
public class NotificationsRecordContentEntity extends AbstractIdAndTimeEntity {

    /**
     * 内容
     */
    private String content;
}
