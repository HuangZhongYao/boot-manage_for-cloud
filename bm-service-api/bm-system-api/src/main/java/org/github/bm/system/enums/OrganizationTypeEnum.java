package org.github.bm.system.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 组织类型枚举
 */
@Getter
@AllArgsConstructor
public enum OrganizationTypeEnum implements IEnum<Integer> {

    /**
     * 公司
     */
    COMPANY(1, "公司"),
    /**
     * 子公司
     */
    SUBSIDIARY(2, "子公司"),
    /**
     * 组织
     */
    ORGANIZATION(3, "组织"),
    /**
     * 部门
     */
    DEPARTMENT(4, "部门"),
    ;
    /**
     * 枚举值
     */
    private final Integer value;
    /**
     * 描述
     */
    private final String desc;
}
