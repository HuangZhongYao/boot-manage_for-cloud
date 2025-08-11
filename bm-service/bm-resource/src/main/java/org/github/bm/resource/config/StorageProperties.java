package org.github.bm.resource.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * 存储配置
 */
@Data
@ConfigurationProperties(prefix = "storage")
public class StorageProperties {

	/**
	 * 是否启用
	 */
	private Boolean enabled;

	/**
	 * 对象存储名称
	 */
	private String name;

	/**
	 * 对象存储服务的URL
	 */
	private String endpoint;

	/**
	 * Access key就像用户ID，可以唯一标识你的账户
	 */
	private String accessKey;

	/**
	 * Secret key是你账户的密码
	 */
	private String secretKey;

	/**
	 * 默认的存储桶名称
	 */
	private String bucketName = "boot-manage";

	/**
	 * 自定义属性
	 */
	private Map<String,String> args;

}
