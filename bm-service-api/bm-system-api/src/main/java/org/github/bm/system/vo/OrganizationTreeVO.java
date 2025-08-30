package org.github.bm.system.vo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.github.bm.common.base.vo.BaseIdAndTimeAndOperationIdVO;
import org.github.bm.common.util.tree.ITreeNode;
import org.github.bm.system.enums.OrganizationTypeEnum;

/**
 * 组织树VO
 * @Desc Created by IntelliJ IDEA.
 * @Author ZhongYao.Huang (https://github.com/HuangZhongYao)
 * @Copyright ZuuuuYao By Github
 * @Time 2025-08-30 22:23
 */
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OrganizationTreeVO extends BaseIdAndTimeAndOperationIdVO implements ITreeNode<Long> {
    /**
     * 组织机构类型名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 父级ID
     */
    private Long parentId;

    /**
     * 父级名称
     */
    private String parentName;

    /**
     * 组织机构类型类型
     */
    private OrganizationTypeEnum type;

    /**
     * 组织机构类型value
     */
    private Integer typeValue;

    /**
     * 组织机构类型描述
     */
    private String typeDesc;

    /**
     * 是否启用
     */
    private Boolean enable;

    /**
     * 负责人id json 数组
     */
    private String leader;

    /**
     * 备注
     */
    private String remark;

    /**
     * 子节点
     */
    private List<ITreeNode<Long>> children;

    public Integer getTypeValue() {
        if (null == type) {
            return null;
        }
        return type.getValue();
    }

    public String getTypeDesc() {
        if (null == type) {
            return null;
        }
        return type.getDesc();
    }
}
