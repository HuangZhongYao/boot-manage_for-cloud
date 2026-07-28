package org.github.bm.common.enums;

import org.github.bm.common.base.enums.IEnumsValue;

public enum DataSourceEnum implements IEnumsValue {
    MYSQL(1, "mysql"),
    ORACLE(2, "oracle"),
    SQLSERVER(3, "sqlserver"),
    POSTGRESQL(4, "postgresql");

    public final Integer value;
    public final String desc;

    DataSourceEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
