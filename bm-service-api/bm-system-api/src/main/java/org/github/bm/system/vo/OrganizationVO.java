package org.github.bm.system.vo;

import lombok.*;
import org.github.bm.common.base.vo.BaseIdAndTimeAndOperationIdVO;
import org.github.bm.system.enums.OrganizationTypeEnum;

/**
 * 组织机构类型表实体（或者也叫部门表实体）
 */
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class OrganizationVO extends BaseIdAndTimeAndOperationIdVO {

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
     * 是否启用
     */
    private Boolean enable;

    /**
     * 描述
     */
    private String description;

    /**
     * 负责人id json 数组
     */
    private String leader;

    /**
     * 备注
     */
    private String remark;
}
