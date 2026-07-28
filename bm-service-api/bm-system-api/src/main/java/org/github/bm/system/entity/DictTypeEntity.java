package org.github.bm.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.github.bm.base.base.entity.AbstractBaseEntity;

import java.io.Serial;

/**
 * 字典类型实体
 *
 * @Desc Created by IntelliJ IDEA.
 * @Author ZhongYao.Huang (https://github.com/HuangZhongYao)
 * @Copyright ZuuuuYao By Github
 * @Time 2024-08-18 3:42
 */
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_dict_type")
public class DictTypeEntity extends AbstractBaseEntity {

    @Serial
    private static final long serialVersionUID = -4909560354235113011L;

    /**
     * 上级
     */
    private Long parentId;

    /**
     * 名称
     */
    private String name;

    /**
     * 字典类型code
     */
    private String code;

    /**
     * 排序值
     */
    private Integer sort;

    /**
     * 启用状态
     */
    private Boolean enable;

    /**
     * 备注
     */
    private String remark;
}
