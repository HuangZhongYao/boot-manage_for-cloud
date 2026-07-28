package org.github.bm.system.enums;

import org.github.bm.base.base.enums.IEnumsValue;

/**
 * 公告通知目标类型枚举
 * Time 2025-08-28 16:21
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
public enum NotificationsTargetEnum implements IEnumsValue {
    USER(1, "用户"),
    ROLE(2, "角色"),
    ORGANIZATION(3, "组织"),
    ALL(4, "全部");

    NotificationsTargetEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public final Integer value;
    public final String desc;

    @Override
    public Integer getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
