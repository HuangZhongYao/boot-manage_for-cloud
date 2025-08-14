package org.github.bm.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.github.bm.system.entity.UserRoleEntity;
import org.github.bm.system.repository.UserRoleRepository;
import org.github.bm.system.service.IUserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleRepository, UserRoleEntity> implements IUserRoleService {
}
