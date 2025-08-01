package org.github.bm.common.enums;

import org.github.bm.common.constant.AppConstant;

/**
 * 微服务枚举
 * Time 2025-07-31 11:17
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
public enum ServiceEnum {
    /**
     * 网关模块枚举
     */
    APPLICATION_GATEWAY("gateway", "网关服务"),
    /**
     * 认证模块枚举
     */
    APPLICATION_AUTH("auth", "认证服务"),
    /**
     * 资源模块枚举
     */
    APPLICATION_RESOURCE("resource", "资源服务"),
    /**
     * springboot admin监控模块枚举
     */
    APPLICATION_ADMIN("admin", "springboot admin服务"),
    /**
     * 系统模块枚举
     */
    APPLICATION_SYSTEM("system", "系统服务"),
    /**
     * 用户模块枚举
     */
    APPLICATION_USER("user", "用户服务"),
    ;

    /**
     * 服务名称
     */
    public final String name;
    /**
     * 服务描述 ,将会作为聚合文档中的服务名称
     */
    public final String desc;

    ServiceEnum(String name, String desc) {
        this.name = AppConstant.APPLICATION_NAME_PREFIX + name;
        this.desc = desc;
    }

    /**
     * 根据名称获取枚举
     * @param name 枚举名称
     * @return 枚举
     */
    public static ServiceEnum getByName(String name) {
        for (ServiceEnum value : ServiceEnum.values()) {
            if (value.name.equals(name)) {
                return value;
            }
        }
        return null;
    }
}
