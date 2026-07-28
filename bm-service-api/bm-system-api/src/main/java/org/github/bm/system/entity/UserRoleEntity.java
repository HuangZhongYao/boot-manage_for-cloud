package org.github.bm.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.github.bm.base.base.entity.AbstractBaseEntity;

import java.io.Serial;

/**
 * @Desc: Created by IntelliJ IDEA.
 * @Author: ZhongYao.Huang
 * @Copyright: ZuuuuYao By Github
 * @Time: 2024-07-16 19:46
 */
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_role")
public class UserRoleEntity extends AbstractBaseEntity {

    @Serial
    private static final long serialVersionUID = -2510671353986711029L;

    /**
     * 角色id {@link RoleEntity#id}
     */
    private Long roleId;

    /**
     * 用户id {@link UserEntity#id}
     */
    private Long userId;
}
