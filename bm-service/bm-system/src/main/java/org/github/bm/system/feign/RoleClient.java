package org.github.bm.system.feign;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.annotation.Resource;
import org.github.bm.system.converter.RoleConverter;
import org.github.bm.system.entity.RoleEntity;
import org.github.bm.system.entity.UserRoleEntity;
import org.github.bm.system.repository.RoleRepository;
import org.github.bm.system.repository.UserRoleRepository;
import org.github.bm.system.service.IUserRoleService;
import org.github.bm.system.vo.RoleVo;
import org.github.bm.system.vo.UserRoleVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@Hidden
@RestController
public class RoleClient implements IRoleClient {

    @Resource
    RoleRepository roleRepository;
    @Resource
    IUserRoleService userRoleService;
    @Resource
    UserRoleRepository userRoleRepository;
    @Resource
    RoleConverter roleConverter;

    @Override
    @PostMapping(GET_ROLE_BY_ID)
    public RoleEntity getRoleById(Serializable id) {
        return roleRepository.selectById(id);
    }

    @Override
    @PostMapping(GET_ROLE_BY_ID_LIST)
    public List<RoleEntity> getRoleByIdList(List<Long> ids) {
        return roleRepository.selectBatchIds(ids);
    }

    @Override
    @PostMapping(GET_ROLE_BY_USER_ID)
    public List<RoleEntity> getRoleByUserId(Serializable userId) {
        List<UserRoleEntity> userRoleEntityList = userRoleRepository.selectList(Wrappers.<UserRoleEntity>lambdaQuery().eq(UserRoleEntity::getUserId, userId));
        if (userRoleEntityList.isEmpty())
            return List.of();

        return roleRepository.selectList(Wrappers.<RoleEntity>lambdaQuery().in(RoleEntity::getId, userRoleEntityList.stream().map(UserRoleEntity::getRoleId).toList()));
    }

    @Override
    @PostMapping(GET_ROLE_VO_BY_USER_ID)
    public List<RoleVo> getRoleVoByUserId(@RequestParam("userId") Serializable userId) {
        return roleConverter.toRoleVo(this.getRoleByUserId(userId));
    }

    @Override
    @PostMapping(GET_ROLE_BY_USER_ID_LIST)
    public List<RoleEntity> getRoleByUserIdList(List<Long> userIds) {
        List<UserRoleEntity> userRoleEntityList = userRoleRepository.selectList(Wrappers.<UserRoleEntity>lambdaQuery().in(UserRoleEntity::getUserId, userIds));
        if (userRoleEntityList.isEmpty())
            return List.of();

        return roleRepository.selectList(Wrappers.<RoleEntity>lambdaQuery().in(RoleEntity::getId, userRoleEntityList.stream().map(UserRoleEntity::getRoleId).toList()));
    }

    @Override
    @PostMapping(GET_USER_ROLE_BY_USER_ID_LIST)
    public List<UserRoleEntity> getUserRoleByUserIdList(@RequestParam("userIds") List<Long> userIds) {
        return userRoleRepository.selectList(Wrappers.<UserRoleEntity>lambdaQuery().in(UserRoleEntity::getUserId, userIds));
    }

    @PostMapping(GET_USER_ROLE_VO_BY_USER_ID_LIST)
    public List<UserRoleVO> getUserRoleVoByUserIdList(@RequestParam("userIds") List<Long> userIds){
        return roleRepository.queryUserRolesByUserIds(userIds);
    }

    @Override
    @PostMapping(DEL_USER_ROLE_BY_USER_ID)
    public Integer delUserRoleByUserId(Serializable userId) {
        return userRoleRepository.delete(Wrappers.<UserRoleEntity>lambdaQuery().eq(UserRoleEntity::getUserId, userId));
    }

    @Override
    @PostMapping(DEL_USER_ROLE_BY_USER_ID_LIST)
    public Integer delUserRoleByUserIds(List<Long> userIds) {
        return userRoleRepository.delete(Wrappers.<UserRoleEntity>lambdaQuery().in(UserRoleEntity::getUserId, userIds));
    }

    @PostMapping(ADD_USER_ROLE_BY_USER_ID)
    public Boolean addUserRoleByUserId(@RequestBody List<UserRoleEntity> userRoleEntityList) {
        return userRoleService.saveBatch(userRoleEntityList);
    }
}
