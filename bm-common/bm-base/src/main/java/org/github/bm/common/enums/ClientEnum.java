package org.github.bm.common.enums;

/**
 * 客户端枚举
 */
public enum ClientEnum {
    WEB("web端", "WEB"),
    PC("PC端", "PC"),
    MOBILE("移动端", "MOBILE"),
    ;
    public final String name;
    public final String code;

    ClientEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
