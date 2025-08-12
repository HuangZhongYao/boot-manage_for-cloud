package org.github.bm.resource.model;

import lombok.Data;

/**
 *
 */
@Data
public class BMFile {
	/**
	 * 文件地址
	 */
	private String link;
	/**
	 * 域名地址
	 */
	private String domain;
	/**
	 * 文件名
	 */
	private String name;
	/**
	 * 原始文件名
	 */
	private String originalName;
}
