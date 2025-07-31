package org.github.bm.common.constant;

import org.github.bm.common.enums.ServiceEnum;

import java.util.Set;

/**
 * 系统常量
 */
public interface AppConstant {

	/**
	 * 应用版本
	 */
	String APPLICATION_VERSION = "1.0.0";

	/**
	 * 基础包
	 */
	String BASE_PACKAGES = "org.github.bm";

	/**
	 * 应用名前缀
	 */
	String APPLICATION_NAME_PREFIX = "bm-";

	/**
	 * 应用微服务集合
	 */
	Set<ServiceEnum> SERVICES = Set.of(ServiceEnum.values());

	/**
	 * 开发环境
	 */
	String DEV_CODE = "dev";
	/**
	 * 生产环境
	 */
	String PROD_CODE = "prod";
	/**
	 * 测试环境
	 */
	String TEST_CODE = "test";

	/**
	 * 代码部署于 linux 上，工作默认为 mac 和 Windows
	 */
	String OS_NAME_LINUX = "LINUX";

}
