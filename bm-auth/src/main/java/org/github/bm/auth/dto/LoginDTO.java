package org.github.bm.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.github.bm.common.base.dto.BaseDTO;
import org.github.bm.common.validate.ValidateNotNullAndEmpty;

import java.io.Serial;

/**
 * @Desc: Created by IntelliJ IDEA.
 * @Author: ZhongYao.Huang
 * @Copyright: ZuuuuYao By Github
 * @Time: 2024-07-15 19:20
 */
@Schema(description = "登录参数模型", name = "登录请求参数")
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class LoginDTO extends BaseDTO {

    @Serial
    private static final long serialVersionUID = 6250000014475264360L;

    @Schema(description = "验证码")
    private String captcha;

    @ValidateNotNullAndEmpty(message = "密码不能为空")
    @Schema(description = "密码")
    private String password;

    @ValidateNotNullAndEmpty(message = "登录账号不能为空")
    @Schema(description = "账号")
    private String account;
}
