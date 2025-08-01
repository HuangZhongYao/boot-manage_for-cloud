package org.github.bm.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.github.bm.common.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.system.vo.RoleVo;
import org.github.bm.user.dto.*;
import org.github.bm.user.service.IUserService;
import org.github.bm.user.vo.UserVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public Boolean resetPassword(ResetPasswordInputDTO inputDTO) {
        return null;
    }

    @Override
    public Boolean changePassword(ChangePasswordInputDTO inputDTO) {
        return null;
    }

    @Override
    public Boolean setState(SetUserStateInputDTO inputDTO) {
        return null;
    }

    @Override
    public Boolean delUser(BaseManyLongIdInputDTO inputDTO) {
        return null;
    }

    @Override
    public Boolean addUser(AddUserInputDTO inputDTO) {
        return null;
    }

    @Override
    public List<RoleVo> queryUserRoleList(Long id) {
        return List.of();
    }

    @Override
    public Page<UserVo> pageQueryList(UserQueryPageInputDTO inputDTO) {
        return null;
    }

    @Override
    public List<UserVo> queryAllUserList() {
        return List.of();
    }

    @Override
    public Boolean setRole(SetRoleInputDTO inputDTO) {
        return null;
    }

    @Override
    public Boolean editUser(EditUserInputDTO inputDTO) {
        return null;
    }
}
