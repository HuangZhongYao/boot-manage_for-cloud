package org.github.bm.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.github.bm.common.base.dto.input.BaseLongIdInputDTO;
import org.github.bm.user.enums.GenderEnum;

import java.io.Serial;

/**
 * @Desc
 * @Time 2024-07-12 11:02
 * @Author HuangZhongYao
 */
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "编辑用户DTO")
public class EditUserInputDTO extends BaseLongIdInputDTO {

    @Serial
    private static final long serialVersionUID = -5329610125578371097L;

    /**
     * 用户名
     */
    @Schema(description = "用户名", example = "宇宙无敌的高手", requiredMode = Schema.RequiredMode.REQUIRED)
    private String username;

    /**
     * 性别
     */
    @Schema(description = "性别", example = "MALE")
    private GenderEnum gender;

    /**
     * 手机号
     */
    @Schema(description = "手机号", example = "17785306043")
    private String phone;

    /**
     * 头像url
     */
    @Schema(description = "头像url", example = "https://avatars.githubusercontent.com/u/46741470?v=4&size=256")
    private String avatarUrl;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;

    /**
     * 启用状态
     */
    @Schema(description = "启用状态: true|false")
    private Boolean enable;
}
