package org.github.bm.system.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.github.bm.common.base.enums.IEnumsValue;

/**
 * 消息通知等级枚举
 * Time 2025-09-04 14:59
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Getter
@AllArgsConstructor
public enum NotificationsTypeEnum implements IEnumsValue {
    SYSTEM(1, "系统通知"),
    ;
    public final Integer value;
    public final String desc;
}
