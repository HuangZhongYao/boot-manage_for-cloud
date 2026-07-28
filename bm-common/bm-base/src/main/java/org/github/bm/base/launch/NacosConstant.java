package org.github.bm.base.launch;

/**
 * Nacos配置常量
 */
public interface NacosConstant {
    /**
     * nacos 配置前缀
     */
    String NACOS_CONFIG_PREFIX = "bm";

    /**
     * nacos 组配置后缀
     */
    String NACOS_GROUP_SUFFIX = "-group";

    /**
     * nacos 配置文件类型
     */
    String NACOS_CONFIG_FORMAT = "yml";

    /**
     * nacos json配置文件类型
     */
    String NACOS_CONFIG_JSON_FORMAT = "json";

    /**
     * nacos 是否刷新
     */
    String NACOS_CONFIG_REFRESH = "true";

    /**
     * nacos 分组
     */
    String NACOS_CONFIG_GROUP = "DEFAULT_GROUP";

    /**
     * 构建服务对应的 dataId
     *
     * @param appName 服务名
     * @return dataId
     */
    static String dataId(String appName) {
        return dataId(appName, NACOS_CONFIG_FORMAT);
    }

    /**
     * 构建服务对应的 dataId
     *
     * @param appName 服务名
     * @param format  文件类型
     * @return dataId
     */
    static String dataId(String appName, String format) {
        return appName + "." + format;
    }

}
