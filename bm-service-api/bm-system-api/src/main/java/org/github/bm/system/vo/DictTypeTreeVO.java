package org.github.bm.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.github.bm.common.base.vo.BaseIdAndTimeAndOperationIdVO;
import org.github.bm.common.util.tree.ITreeNode;

import java.io.Serial;
import java.util.List;


/**
 * 系统字典类型表VO对象
 *
 * @Desc Created by Velocity Generate.
 * @Time 2024-08-18 05:13:04
 * @Author zuuuYao (https://github.com/HuangZhongYao)
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DictTypeTreeVO extends BaseIdAndTimeAndOperationIdVO implements ITreeNode<Long> {

    @Serial
    private static final long serialVersionUID = -1;

    /**
     * 上级
     */
    @Schema(description = "上级")
    private Long parentId;

    /**
     * 名称
     */
    @Schema(description = "名称")
    private String name;

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

    /**
     * 下级数据
     */
    @Schema(description = "下级数据")
    List<ITreeNode<Long>> children;
}

