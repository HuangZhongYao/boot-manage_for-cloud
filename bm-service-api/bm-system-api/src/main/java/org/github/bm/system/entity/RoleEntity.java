package org.github.bm.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.github.bm.base.base.entity.AbstractBaseEntity;

import java.io.Serial;

/**
 * 角色表
 *
 * @Desc: Created by IntelliJ IDEA.
 * @Author: ZhongYao.Huang
 * @Copyright: ZuuuuYao By Github
 * @Time: 2024-07-13 18:27
 */
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role")
public class RoleEntity extends AbstractBaseEntity {

    @Serial
    private static final long serialVersionUID = -8866939458137795129L;

    /**
     * 图标
     */
    private String icon;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    /**
     * 启用状态
     */
    private Boolean enable;

    /**
     * 角色编码
     */
    private String code;
}
