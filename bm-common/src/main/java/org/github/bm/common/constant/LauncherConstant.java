package org.github.bm.common.constant;


/**
 * 通用常量
 *
 * @author Chill
 */
public interface LauncherConstant {

	/**
	 * nacos namespace id ,为空为public
	 */
	String NACOS_NAMESPACE = "";

	/**
	 * nacos dev 地址
	 */
	String NACOS_DEV_ADDR = "127.0.0.1:8848";

	/**
	 * nacos prod 地址
	 */
	String NACOS_PROD_ADDR = "172.30.0.48:8848";

	/**
	 * nacos test 地址
	 */
	String NACOS_TEST_ADDR = "172.30.0.48:8848";

	/**
	 * sentinel dev 地址
	 */
	String SENTINEL_DEV_ADDR = "127.0.0.1:8858";

	/**
	 * sentinel prod 地址
	 */
	String SENTINEL_PROD_ADDR = "172.30.0.58:8858";

	/**
	 * sentinel test 地址
	 */
	String SENTINEL_TEST_ADDR = "172.30.0.58:8858";

	/**
	 * zipkin dev 地址
	 */
	String ZIPKIN_DEV_ADDR = "http://127.0.0.1:9411";

	/**
	 * zipkin prod 地址
	 */
	String ZIPKIN_PROD_ADDR = "http://172.30.0.58:9411";

	/**
	 * zipkin test 地址
	 */
	String ZIPKIN_TEST_ADDR = "http://172.30.0.58:9411";

	/**
	 * 动态获取nacos地址
	 *
	 * @param profile 环境变量
	 * @return addr
	 */
	static String nacosAddr(String profile) {
		if (null == profile)
			return NACOS_DEV_ADDR;
		return switch (profile) {
			case AppConstant.PROD_CODE -> NACOS_PROD_ADDR;
			case AppConstant.TEST_CODE -> NACOS_TEST_ADDR;
			default -> NACOS_DEV_ADDR;
		};
	}

	/**
	 * 动态获取sentinel地址
	 *
	 * @param profile 环境变量
	 * @return addr
	 */
	static String sentinelAddr(String profile) {
		if (null == profile)
			return SENTINEL_DEV_ADDR;
		return switch (profile) {
			case AppConstant.PROD_CODE -> SENTINEL_PROD_ADDR;
			case AppConstant.TEST_CODE -> SENTINEL_TEST_ADDR;
			default -> SENTINEL_DEV_ADDR;
		};
	}

	/**
	 * 动态获取zipkin地址
	 *
	 * @param profile 环境变量
	 * @return addr
	 */
	static String zipkinAddr(String profile) {
		if (null == profile)
			return ZIPKIN_DEV_ADDR;
		return switch (profile) {
			case AppConstant.PROD_CODE -> ZIPKIN_PROD_ADDR;
			case AppConstant.TEST_CODE -> ZIPKIN_TEST_ADDR;
			default -> ZIPKIN_DEV_ADDR;
		};
	}


}
