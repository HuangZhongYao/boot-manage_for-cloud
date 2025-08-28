package org.github.bm.system.repository;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.github.bm.common.mybatis.BaseMapperExtension;
import org.github.bm.system.dto.RolePageQueryInputDTO;
import org.github.bm.system.entity.RoleEntity;
import org.github.bm.system.vo.RolePageQueryListItemVO;
import org.github.bm.system.vo.RoleVO;
import org.github.bm.system.vo.UserRoleVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Desc: Created by IntelliJ IDEA.
 * @Author: ZhongYao.Huang
 * @Copyright: ZuuuuYao By Github
 * @Time: 2024-07-13 18:39
 */
@Repository
public interface RoleRepository extends BaseMapperExtension<RoleEntity> {

    /**
     * 分页查询
     *
     * @param page     分页插件参数
     * @param inputDTO 查询参数
     * @return 分页结果
     */
    Page<RolePageQueryListItemVO> pageQueryList(@Param("page") Page page,
                                                @Param("param") RolePageQueryInputDTO inputDTO);

    /**
     * 查询用户角色根据用户id
     *
     * @param userId 用户id
     * @return 角色列表
     */
    List<RoleVO> queryUserRolesByUserId(@Param("userId") Long userId);

    /**
     * 批量查询用户角色根据用户id
     *
     * @param userIds 用户id集合
     * @return 角色列表
     */
    List<UserRoleVO> queryUserRolesByUserIds(@Param("userIds") List<Long> userIds);
}
