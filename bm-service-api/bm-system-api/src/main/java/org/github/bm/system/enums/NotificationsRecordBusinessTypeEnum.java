package org.github.bm.system.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.github.bm.common.base.enums.IEnumsValue;

/**
 * 通知记录业务场景类型枚举。
 * Time 2025-11-10 14:33
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Getter
@AllArgsConstructor
public enum NotificationsRecordBusinessTypeEnum implements IEnumsValue {
    /**
     * 普通通知无跳转业务场景
     */
    ORDINARY(0, "普通通知"),
    /**
     * 系统公告
     */
    NOTIFICATIONS(1, "系统公告"),
    ;

    /**
     * 枚举值
     */
    public final Integer value;

    /**
     * 描述
     */
    public final String desc;
}
