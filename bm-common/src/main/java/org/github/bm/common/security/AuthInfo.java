
package org.github.bm.common.security;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "认证信息")
public class AuthInfo implements Serializable {

	@Schema(description = "令牌前缀")
	private String tokenPrefix;

	@Schema(description = "令牌")
	private String accessToken;

	@Schema(description = "刷新令牌")
	private String refreshToken;

	@Schema(description = "用户ID")
	private Long userId;

	@Schema(description = "头像")
	private String avatar;

	@Schema(description = "角色名")
	private String role;

	@Schema(description = "用户名")
	private String userName;

	@Schema(description = "账号名")
	private String account;

	@Schema(description = "过期时间")
	private long expiresIn;

}
