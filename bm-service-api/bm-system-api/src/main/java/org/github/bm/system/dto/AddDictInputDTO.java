package org.github.bm.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.github.bm.common.base.dto.BaseDTO;
import org.github.bm.common.validate.ValidateNotNullAndEmpty;

import java.io.Serial;

/**
 * 添加字典DTO对象
 * @Desc Created by IntelliJ IDEA.
 * @Author ZhongYao.Huang (https://github.com/HuangZhongYao)
 * @Copyright ZuuuuYao By Github
 * @Time 2024-08-18 4:10
 */
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class AddDictInputDTO extends BaseDTO {
    @Serial
    private static final long serialVersionUID = -8700687522302184350L;

    /**
     * 字典数据类型id
     */
    @Schema(description = "字典数据类型id",requiredMode = Schema.RequiredMode.REQUIRED)
    @ValidateNotNullAndEmpty(message = "字典数据类型id不能为空")
    private Long dictTypeId;

    /**
     * 名称
     */
    @ValidateNotNullAndEmpty(message = "字典名称不能为空")
    @Schema(description = "名称",requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    /**
     * 编码
     */
    @ValidateNotNullAndEmpty(message = "字典编码不能为空")
    @Schema(description = "编码",requiredMode = Schema.RequiredMode.REQUIRED)
    private String code;

    /**
     * 排序值
     */
    @Schema(description = "排序值")
    private Integer sort;

    /**
     * 启用状态
     */
    @Schema(description = "启用状态")
    private Boolean enable;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;
}
