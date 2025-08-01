package org.github.bm.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.github.bm.common.base.dto.BaseDTO;
import org.github.bm.common.validate.ValidateNotNullAndEmpty;

import java.io.Serial;
import java.util.ArrayList;

/**
 * @Desc: Created by IntelliJ IDEA.
 * @Author: ZhongYao.Huang
 * @Copyright: ZuuuuYao By Github
 * @Time: 2024-07-16 19:41
 */
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SetRoleInputDTO extends BaseDTO {

    @Serial
    private static final long serialVersionUID = -2652755823180838443L;

    @Schema(description = "用户id", example = "12684")
    @ValidateNotNullAndEmpty(message = "用户id不能为空")
    private Long userId;

    /**
     * 角色id
     */
    @Schema(description = "角色id集合", example = "[1]")
    @ValidateNotNullAndEmpty(message = "角色不能为空")
    private ArrayList<Long> roleIds;

}
