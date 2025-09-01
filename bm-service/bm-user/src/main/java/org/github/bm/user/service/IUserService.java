package org.github.bm.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.github.bm.common.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.system.vo.RoleVO;
import org.github.bm.user.dto.*;
import org.github.bm.user.vo.UserVO;

import java.util.List;

/**
 * 用户服务接口
 * 定义了用户相关的业务操作接口
 */
public interface IUserService {
    /**
     * 重置用户密码
     * @param inputDTO 重置密码输入参数，包含用户ID和新密码信息
     * @return Boolean 重置结果，true表示成功，false表示失败
     */
    Boolean resetPassword(ResetPasswordInputDTO inputDTO);

    /**
     * 修改用户密码
     * @param inputDTO 修改密码输入参数，包含用户ID、原密码和新密码信息
     * @return Boolean 修改结果，true表示成功，false表示失败
     */
    Boolean changePassword(ChangePasswordInputDTO inputDTO);

    /**
     * 设置用户状态
     * @param inputDTO 设置用户状态输入参数，包含用户ID和状态信息
     * @return Boolean 设置结果，true表示成功，false表示失败
     */
    Boolean setState(SetUserStateInputDTO inputDTO);

    /**
     * 删除用户
     * @param inputDTO 删除用户输入参数，包含要删除的用户ID列表
     * @return Boolean 删除结果，true表示成功，false表示失败
     */
    Boolean delUser(BaseManyLongIdInputDTO inputDTO);

    /**
     * 添加用户
     * @param inputDTO 添加用户输入参数，包含用户基本信息
     * @return Boolean 添加结果，true表示成功，false表示失败
     */
    Boolean addUser(AddUserInputDTO inputDTO);

    /**
     * 查询用户角色列表
     * @param id 用户ID
     * @return List<RoleVO> 用户拥有的角色列表
     */
    List<RoleVO> queryUserRoleList(Long id);

    /**
     * 分页查询用户列表
     * @param inputDTO 分页查询输入参数，包含分页信息和查询条件
     * @return Page<UserVO> 分页用户信息列表
     */
    Page<UserVO> pageQueryList(UserQueryPageInputDTO inputDTO);

    /**
     * 查询所有用户列表
     * @return List<UserVO> 所有用户信息列表
     */
    List<UserVO> queryAllUserList();

    /**
     * 设置用户角色
     * @param inputDTO 设置角色输入参数，包含用户ID和角色ID列表
     * @return Boolean 设置结果，true表示成功，false表示失败
     */
    Boolean setRole(SetRoleInputDTO inputDTO);

    /**
     * 编辑用户信息
     * @param inputDTO 编辑用户输入参数，包含用户ID和更新的用户信息
     * @return Boolean 编辑结果，true表示成功，false表示失败
     */
    Boolean editUser(EditUserInputDTO inputDTO);
}

