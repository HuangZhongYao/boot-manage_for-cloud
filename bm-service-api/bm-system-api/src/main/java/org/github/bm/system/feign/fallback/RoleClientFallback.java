package org.github.bm.system.feign.fallback;

import org.github.bm.system.entity.RoleEntity;
import org.github.bm.system.entity.UserRoleEntity;
import org.github.bm.system.feign.IRoleClient;
import org.github.bm.system.vo.RoleVO;
import org.github.bm.system.vo.UserRoleVO;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * Time 2025-09-01 16:33
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Component
public class RoleClientFallback implements IRoleClient {
    /**
     * 根据id查询角色
     *
     * @param id 角色id
     * @return 角色
     */
    @Override
    public RoleEntity getRoleById(Serializable id) {
        return null;
    }

    /**
     * 根据id列表查询角色
     *
     * @param ids id列表
     * @return 角色列表
     */
    @Override
    public List<RoleEntity> getRoleByIdList(List<Long> ids) {
        return List.of();
    }

    /**
     * 根据用户id查询角色
     *
     * @param userId 用户id
     * @return 角色列表
     */
    @Override
    public List<RoleEntity> getRoleByUserId(Serializable userId) {
        return List.of();
    }

    /**
     * 根据用户id查询角色
     *
     * @param userId 用户id
     * @return 角色列表
     */
    @Override
    public List<RoleVO> getRoleVoByUserId(Serializable userId) {
        return List.of();
    }

    /**
     * 根据用户id列表查询角色
     *
     * @param userIds 用户id列表
     * @return 角色列表
     */
    @Override
    public List<RoleEntity> getRoleByUserIdList(List<Long> userIds) {
        return List.of();
    }

    /**
     * 根据用户id列表查询用户关联角色
     *
     * @param userIds 用户id
     * @return 用户关联角色列表
     */
    @Override
    public List<UserRoleEntity> getUserRoleByUserIdList(List<Long> userIds) {
        return List.of();
    }

    /**
     * 根据用户id列表查询用户关联角色
     *
     * @param userIds 用户id列表
     * @return 用户关联角色列表
     */
    @Override
    public List<UserRoleVO> getUserRoleVoByUserIdList(List<Long> userIds) {
        return List.of();
    }

    /**
     * 根据用户id删除用户关联角色
     *
     * @param userId 用户id
     * @return 删除数量
     */
    @Override
    public Integer delUserRoleByUserId(Serializable userId) {
        return 0;
    }

    /**
     * 根据用户id列表删除用户关联角色
     *
     * @param userIds 用户id列表
     * @return 删除数量
     */
    @Override
    public Integer delUserRoleByUserIds(List<Long> userIds) {
        return 0;
    }

    /**
     * 给用户添加关联角色
     *
     * @param userRoleEntityList 用户角色关联实体列表
     * @return 是否成功
     */
    @Override
    public Boolean addUserRoleByUserId(List<UserRoleEntity> userRoleEntityList) {
        return null;
    }
}
