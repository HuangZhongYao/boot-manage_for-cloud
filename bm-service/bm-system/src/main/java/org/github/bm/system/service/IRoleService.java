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
    Boolean addRole(AddRoleInputDTO inputDTO);

    Boolean delRole(BaseManyLongIdInputDTO inputDTO);

    Page<RolePageQueryListItemVO> pageQueryList(RolePageQueryInputDTO inputDTO);

    List<RoleVO> queryList(Boolean enable);

    Boolean editRole(EditRoleInputDTO inputDTO);

    List<RoleUserModel> queryRoleUserList(Long id);

    /**
     * 批量给角色设置用户
     *
     * @param inputDTO SetRoleUserInputDTO
     * @return 成功true
     */
    Boolean setRoleUser(SetRoleUserInputDTO inputDTO);

    /**
     * 设置角色启用状态
     *
     * @param inputDTO
     * @return
     */
    Boolean setState(SetRoleStateInputDTO inputDTO);

}
