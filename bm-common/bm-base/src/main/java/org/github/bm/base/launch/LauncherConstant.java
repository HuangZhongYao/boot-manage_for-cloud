package org.github.bm.base.launch;

import org.github.bm.base.constant.AppConstant;

public interface LauncherConstant {

    interface NacosConstant {
        /**
         * nacos用户名如果开启认证则填写
         */
        String NACOS_USERNAME = "";
        /**
         * nacos密码如果开启认证则填写
         */
        String NACOS_PASSWORD = "";
        /**
         * nacos dev 命名空间 id ,为空为public
         */
        String NACOS_DEV_NAMESPACE = "9a019fa4-2b71-48d1-bf7c-23f4e4c0395a";

        /**
         * nacos test 命名空间 id ,为空为public
         */
        String NACOS_TEST_NAMESPACE = "3ae2a34e-8ac6-46c3-bcb5-1c4eb6195dcf";

        /**
         * nacos prod 命名空间 id ,为空为public
         */
        String NACOS_PROD_NAMESPACE = "a64b1361-f8c7-46d9-95c7-ea2ad9d336b4";

        /**
         * nacos dev 地址
         */
        String NACOS_DEV_ADDR = "127.0.0.1:8848";

        /**
         * nacos prod 地址
         */
        String NACOS_PROD_ADDR = "192.168.1.219:8848";

        /**
         * nacos test 地址
         */
        String NACOS_TEST_ADDR = "192.168.1.219:8848";
    }

    interface SentinelConstant {
        /**
         * sentinel dev 地址
         */
        String SENTINEL_DEV_ADDR = "127.0.0.1:8858";

        /**
         * sentinel prod 地址
         */
        String SENTINEL_PROD_ADDR = "192.168.1.219:8858";

        /**
         * sentinel test 地址
         */
        String SENTINEL_TEST_ADDR = "192.168.1.219:8858";
    }

    /**
     * 动态获取nacos命名空间id
     *
     * @param profile 环境变量
     * @return namespaceId 命名空间id
     */
    static String nacosNamespace(String profile) {
        if (null == profile) return NacosConstant.NACOS_DEV_NAMESPACE;
        return switch (profile) {
            case AppConstant.PROD_CODE -> NacosConstant.NACOS_PROD_NAMESPACE;
            case AppConstant.TEST_CODE -> NacosConstant.NACOS_TEST_NAMESPACE;
            default -> NacosConstant.NACOS_DEV_NAMESPACE;
        };
    }

    /**
     * 动态获取nacos地址
     *
     * @param profile 环境变量
     * @return addr
     */
    static String nacosAddr(String profile) {
        if (null == profile) return NacosConstant.NACOS_DEV_ADDR;
        return switch (profile) {
            case AppConstant.PROD_CODE -> NacosConstant.NACOS_PROD_ADDR;
            case AppConstant.TEST_CODE -> NacosConstant.NACOS_TEST_ADDR;
            default -> NacosConstant.NACOS_DEV_ADDR;
        };
    }

    /**
     * 动态获取sentinel地址
     *
     * @param profile 环境变量
     * @return addr
     */
    static String sentinelAddr(String profile) {
        if (null == profile) return SentinelConstant.SENTINEL_DEV_ADDR;
        return switch (profile) {
            case AppConstant.PROD_CODE -> SentinelConstant.SENTINEL_PROD_ADDR;
            case AppConstant.TEST_CODE -> SentinelConstant.SENTINEL_TEST_ADDR;
            default -> SentinelConstant.SENTINEL_DEV_ADDR;
        };
    }
}
