
package org.github.bm.common.security;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.github.bm.common.base.vo.BaseVO;
import org.github.bm.common.enums.GenderEnum;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Schema(description = "认证信息")
public class AuthInfo extends BaseVO {

    @Schema(description = "令牌header名称")
    private String authHeaderKey = SecurityConstants.AUTH_HEADER_KEY;

    @Schema(description = "refreshToken令牌header名称")
    private String refreshAuthHeaderKey = SecurityConstants.REFRESH_AUTH_HEADER_KEY;

    @Schema(description = "令牌前缀")
    private String tokenPrefix = SecurityConstants.AUTH_HEADER_PREFIX;

    @Schema(description = "令牌")
    private String accessToken;

    @Schema(description = "刷新令牌")
    private String refreshToken;

    @Schema(description = "用户ID")
    private Long userId;

    @Schema(description = "头像")
    private String avatarUrl;

    @Schema(description = "角色名")
    private String role;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "性别")
    private GenderEnum gender;

    @Schema(description = "手机号")
    private String phone;

    @Schema(description = "最后登录时间")
    private LocalDateTime lastLoginTime;

    @Schema(description = "账号名")
    private String account;

    @Schema(description = "accessToken过期时间")
    private Date accessTokenExpiresIn;

    @Schema(description = "refreshToken过期时间")
    private Date refreshTokenExpiresIn;

    @Schema(description = "备注")
    private String remark;

}
