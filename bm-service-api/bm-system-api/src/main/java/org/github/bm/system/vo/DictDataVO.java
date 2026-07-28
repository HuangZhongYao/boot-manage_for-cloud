package org.github.bm.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.github.bm.base.base.vo.BaseIdAndTimeAndOperationIdVO;

import java.io.Serial;


/**
 * 系统字典表VO对象
 *
 * @Desc Created by Velocity Generate.
 * @Time 2024-08-18 04:22:07
 * @Author zuuuYao (https://github.com/HuangZhongYao)
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DictDataVO extends BaseIdAndTimeAndOperationIdVO {

    @Serial
    private static final long serialVersionUID = -1;

    /**
     * 字典数据类型id
     */
    @Schema(description = "字典数据类型id")
    private Long dictTypeId;

    /**
     * 字典数据类型code
     */
    @Schema(description = "字典数据类型code")
    private String typeCode;

    /**
     * 名称
     */
    @Schema(description = "名称")
    private String name;

    /**
     * 编码
     */
    @Schema(description = "编码")
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

