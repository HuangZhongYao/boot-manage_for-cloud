package org.github.bm.system.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.github.bm.common.base.enums.IEnumsValue;

/**
 * 消息通知类型枚举
 * Time 2025-09-04 14:59
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Getter
@AllArgsConstructor
public enum NotificationsLevelEnum implements IEnumsValue {
    ORDINARY(1, "低"),
    WARNING(2, "中"),
    HIGH(3, "高"),
    ;
    public final Integer value;
    public final String desc;
}
