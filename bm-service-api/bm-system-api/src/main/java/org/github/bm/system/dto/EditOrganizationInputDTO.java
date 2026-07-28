package org.github.bm.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.github.bm.base.base.dto.input.BaseLongIdInputDTO;
import org.github.bm.base.validate.ValidateNotNullAndEmpty;
import org.github.bm.system.enums.OrganizationTypeEnum;

/**
 * 新增组织机构输入参数
 */
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "编辑组织机构输入参数")
public class EditOrganizationInputDTO extends BaseLongIdInputDTO {

    /**
     * 组织机构类型名称
     */
    @Schema(description = "组织机构名称", example = "技术部")
    @ValidateNotNullAndEmpty(message = "名称不能为空")
    private String name;

    /**
     * 排序
     */
    @Schema(description = "排序值，数值越小越靠前", example = "1")
    private Integer sort;

    /**
     * 父级ID
     */
    @Schema(description = "父级组织机构ID，顶级null", example = "1")
    private Long parentId;

    /**
     * 组织机构类型
     */
    @Schema(description = "组织机构类型枚举值")
    @ValidateNotNullAndEmpty(message = "类型不能为空")
    private OrganizationTypeEnum type;

    /**
     * 是否启用
     */
    @Schema(description = "是否启用，true-启用，false-禁用", example = "true")
    @ValidateNotNullAndEmpty(message = "是否启用不能为空")
    private Boolean enable;

    /**
     * 负责人id json 数组
     */
    @Schema(description = "负责人ID的JSON数组格式，如：[\"1\",\"2\"]", example = "[\"1\",\"2\"]")
    private String leader;

    /**
     * 备注
     */
    @Schema(description = "备注信息", example = "这是备注内容")
    private String remark;
}
