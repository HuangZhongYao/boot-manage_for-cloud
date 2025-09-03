package org.github.bm.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.github.bm.common.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.system.dto.*;
import org.github.bm.system.vo.RolePageQueryListItemVO;
import org.github.bm.system.vo.RoleUserModel;
import org.github.bm.system.vo.RoleVO;

import java.util.List;

/**
 * @Desc 角色管理 Service
 * @Time 2024-07-12 16:49
 * @Author HuangZhongYao
 */
public interface IRoleService {
    /**
     * 添加角色
     *
     * @param inputDTO 添加角色输入参数
     * @return 添加成功返回true，否则返回false
     */
    Boolean addRole(AddRoleInputDTO inputDTO);

    /**
     * 删除角色
     *
     * @param inputDTO 包含多个角色ID的输入参数
     * @return 删除成功返回true，否则返回false
     */
    Boolean delRole(BaseManyLongIdInputDTO inputDTO);

    /**
     * 分页查询角色列表
     *
     * @param inputDTO 分页查询条件输入参数
     * @return 分页查询结果，包含角色列表信息
     */
    Page<RolePageQueryListItemVO> pageQueryList(RolePageQueryInputDTO inputDTO);

    /**
     * 查询角色列表
     *
     * @param enable 是否启用状态筛选条件，null表示不筛选
     * @return 角色列表
     */
    List<RoleVO> queryList(Boolean enable);

    /**
     * 编辑角色
     *
     * @param inputDTO 编辑角色输入参数
     * @return 编辑成功返回true，否则返回false
     */
    Boolean editRole(EditRoleInputDTO inputDTO);

    /**
     * 查询角色用户列表
     *
     * @param id 角色ID
     * @return 角色关联的用户列表
     */
    List<RoleUserModel> queryRoleUserList(Long id);

    /**
     * 批量查询角色用户列表
     *
     * @param ids 角色ID列表
     * @return 角色关联的用户列表
     */
    List<RoleUserModel> queryRoleUserList(List<Long> ids);

    /**
     * 给角色设置用户
     *
     * @param inputDTO SetRoleUserInputDTO
     * @return 成功true
     */
    Boolean setRoleUser(SetRoleUserInputDTO inputDTO);

    /**
     * 设置角色启用状态
     *
     * @param inputDTO 角色状态设置输入参数
     * @return 设置成功返回true，否则返回false
     */
    Boolean setState(SetRoleStateInputDTO inputDTO);

}

