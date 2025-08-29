package org.github.bm.system.enums;

import org.github.bm.common.base.enums.IEnumsValue;

/**
 * 公告通知状态枚举
 * Time 2025-08-28 16:21
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
public enum NotificationsStateEnum implements IEnumsValue {
    DRAFT(1, "草稿"),
    PUBLISHED(2, "已发布"),
    WITHDRAWAL(3, "已撤回");

    NotificationsStateEnum(Integer value, String desc) {
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
