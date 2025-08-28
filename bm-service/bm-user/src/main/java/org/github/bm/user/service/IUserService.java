package org.github.bm.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.github.bm.common.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.system.vo.RoleVO;
import org.github.bm.user.dto.*;
import org.github.bm.user.vo.UserVO;

import java.util.List;

public interface IUserService {
    Boolean resetPassword(ResetPasswordInputDTO inputDTO);

    Boolean changePassword(ChangePasswordInputDTO inputDTO);

    Boolean setState(SetUserStateInputDTO inputDTO);

    Boolean delUser(BaseManyLongIdInputDTO inputDTO);

    Boolean addUser(AddUserInputDTO inputDTO);

    List<RoleVO> queryUserRoleList(Long id);

    Page<UserVO> pageQueryList(UserQueryPageInputDTO inputDTO);

    List<UserVO> queryAllUserList();

    Boolean setRole(SetRoleInputDTO inputDTO);

    Boolean editUser(EditUserInputDTO inputDTO);
}
