package org.github.bm.user.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.github.bm.base.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.base.exception.UserFriendlyException;
import org.github.bm.base.util.ModelMapperUtil;
import org.github.bm.system.entity.OrganizationEntity;
import org.github.bm.system.entity.UserRoleEntity;
import org.github.bm.system.feign.IOrganizationClient;
import org.github.bm.system.feign.IRoleClient;
import org.github.bm.system.vo.RoleVO;
import org.github.bm.system.vo.UserRoleVO;
import org.github.bm.user.converter.UserConverter;
import org.github.bm.user.dto.*;
import org.github.bm.user.entity.UserEntity;
import org.github.bm.user.repository.UserRepository;
import org.github.bm.user.service.IUserService;
import org.github.bm.user.vo.UserVO;
import org.github.bm.websocket.feign.IOnlineUserClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Desc
 * @Time 2024-07-11 16:33
 * @Author HuangZhongYao
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    UserRepository userRepository;
    @Resource
    IRoleClient roleClient;
    @Resource
    IOrganizationClient organizationClient;
    @Resource
    IOnlineUserClient onlineUserClient;
    @Resource
    private UserConverter userConverter;

    @Override
    public Page<UserVO> pageQueryList(UserQueryPageInputDTO inputDTO) {
        // 构建查询条件
        LambdaQueryWrapper<UserEntity> queryWrapper = Wrappers.<UserEntity>lambdaQuery()
                .like(StrUtil.isNotBlank(inputDTO.getAccount()), UserEntity::getAccount, inputDTO.getAccount())
                .like(StrUtil.isNotBlank(inputDTO.getUsername()), UserEntity::getAccount, inputDTO.getUsername())
                .eq(null != inputDTO.getGender(), UserEntity::getGender, inputDTO.getGender())
                .eq(null != inputDTO.getEnable(), UserEntity::getEnable, inputDTO.getEnable());

        // 用户所属组织Map
        Map<Long, OrganizationEntity> organizationByIdGrouping = new HashMap<>();

        // 添加组织id条件
        if (null != inputDTO.getOrganizationId()) {
            // 查询组织及子组织
            List<OrganizationEntity> organizationAndSubOrganizationList = organizationClient.getOrganizationAndSubOrganization(inputDTO.getOrganizationId());
            List<Long> organizationIdList = organizationAndSubOrganizationList.stream().map(OrganizationEntity::getId).toList();
            // 添加组织id条件
            queryWrapper.in(!organizationIdList.isEmpty(), UserEntity::getOrganizationId, organizationIdList);
            // 组织根据组织id进行分组
            organizationByIdGrouping = organizationAndSubOrganizationList.stream().collect(Collectors.toMap(OrganizationEntity::getId, v -> v));
        }

        // 执行查询用户
        Page<UserVO> page = userRepository.selectPage(inputDTO.toMybatisPageObject(), queryWrapper, UserVO.class);

        // 用户id列表
        List<Long> userIds = page.getRecords().stream().map(UserVO::getId).toList();
        userIds = userIds.isEmpty() ? List.of(-99999L) : userIds;
        // 查询全部用的角色并根据用户id分组
        Map<Long, List<UserRoleVO>> userRoleByUserIdGrouping = roleClient.getUserRoleVoByUserIdList(userIds).stream().collect(Collectors.groupingBy(UserRoleVO::getUserId));

        // 如果organizationByIdGrouping为空则查询用户所属组织
        if (organizationByIdGrouping.isEmpty()) {
            // 全部用户的组织id列表
            List<Long> userOOrganizationIdList = page.getRecords().stream().map(UserVO::getOrganizationId).toList();
            // 默认值避免mybatis-plus报错
            userOOrganizationIdList = userOOrganizationIdList.isEmpty() ? List.of(-99999L) : userOOrganizationIdList;
            // 一次查询全部用户的所属组织
            List<OrganizationEntity> organizationEntityList = organizationClient.getOrganizationByIds(userOOrganizationIdList);
            organizationByIdGrouping = organizationEntityList.stream().collect(Collectors.toMap(OrganizationEntity::getId, item -> item));
        }

        // 设置用户角色和所属部门名称
        for (UserVO userVO : page.getRecords()) {
            userVO.setRoles(userRoleByUserIdGrouping.get(userVO.getId()));
            OrganizationEntity userOrganization = organizationByIdGrouping.get(userVO.getOrganizationId());
            if (null != userOrganization) {
                userVO.setOrganizationName(userOrganization.getName());
            }
        }

        return page;
    }

    @Override
    public List<UserVO> queryAllUserList() {
        return this.userRepository.selectList(null, UserVO.class);
    }

    @Override
    public List<RoleVO> queryUserRoleList(Long id) {
        // 查询用户的角色id
        List<Long> roleIds = roleClient.getUserRoleByUserIdList(List.of(id))
                .stream()
                .map(UserRoleEntity::getRoleId)
                .toList();

        if (roleIds.isEmpty()) {
            return new ArrayList<>();
        }
        // 查询角色信息
        return ModelMapperUtil.mapList(roleClient.getRoleByIdList(roleIds), RoleVO.class);
    }

    @Override
    public Boolean delUser(BaseManyLongIdInputDTO inputDTO) {
        // 删除用户角色中间表数据
        roleClient.delUserRoleByUserIds(inputDTO.getIds());
        // 删除用户
        userRepository.deleteByIds(inputDTO.getIds());
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean addUser(AddUserInputDTO inputDTO) {

        // 判断账号是否已存在
        if (userRepository.exists(
                Wrappers.<UserEntity>lambdaQuery().eq(UserEntity::getAccount, inputDTO.getAccount()))) {
            throw new UserFriendlyException("账号已存在", 411);
        }

        // 将DTO转换为实体对象
        UserEntity userEntity = ModelMapperUtil.map(inputDTO, UserEntity.class, target -> {
            // 设置密码盐
            String pwdSalt = RandomUtil.randomString(8);
            target.setSalt(pwdSalt);

            // 设置密码
            String pwd = DigestUtil.sha256Hex(inputDTO.getPassword() + pwdSalt, CharsetUtil.UTF_8);
            target.setPassword(pwd);
        });
        // 插入数据库
        userRepository.insert(userEntity);

        // 设置角色
        if (CollectionUtil.isNotEmpty(inputDTO.getRoleIds())) {
            List<UserRoleEntity> userRoleEntityList = inputDTO.getRoleIds()
                    .stream()
                    .map(roleId -> UserRoleEntity
                            .builder()
                            .roleId(roleId)
                            .userId(userEntity.getId())
                            .build())
                    .toList();

            this.roleClient.addUserRoleByUserId(userRoleEntityList);
        }

        return true;
    }

    @Override
    public Boolean resetPassword(ResetPasswordInputDTO inputDTO) {

        // 修改条件
        LambdaQueryWrapper<UserEntity> wrapper = Wrappers
                .<UserEntity>lambdaQuery()
                .eq(UserEntity::getId, inputDTO.getId())
                .last(" limit 1 ");

        // 设置密码盐
        String pwdSalt = RandomUtil.randomString(8);

        // 设置密码
        String pwd = DigestUtil.sha256Hex(inputDTO.getPassword() + pwdSalt, CharsetUtil.UTF_8);

        UserEntity userEntity = UserEntity
                .builder()
                .salt(pwdSalt)
                .password(pwd)
                .build();

        // 执行更新
        int result = this.userRepository.update(userEntity, wrapper);

        if (result == 0) {
            throw new UserFriendlyException("修改密码失败");
        }
        return true;
    }

    @Override
    public Boolean changePassword(ChangePasswordInputDTO inputDTO) {

        // 用户数据
        UserEntity userEntity = userRepository.selectById(inputDTO.getId());

        // 判断输入旧密码是否正确
        String oldPwd = DigestUtil.sha256Hex(inputDTO.getOldPassword() + userEntity.getSalt(),
                CharsetUtil.UTF_8);
        if (!StrUtil.equals(userEntity.getPassword(), oldPwd)) {
            throw new UserFriendlyException("输入旧密码不正确", 420);
        }

        // 设置密码盐
        String pwdSalt = RandomUtil.randomString(8);
        // 设置密码
        String pwd = DigestUtil.sha256Hex(inputDTO.getNewPassword() + pwdSalt, CharsetUtil.UTF_8);

        // 设置更新数据
        UserEntity updateEntity = UserEntity
                .builder()
                .salt(pwdSalt)
                .password(pwd)
                .build();
        updateEntity.setId(updateEntity.getId());

        // 执行更新密码
        userRepository.updateById(updateEntity);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean setRole(SetRoleInputDTO inputDTO) {

        // 先清空角色
        roleClient.delUserRoleByUserId(inputDTO.getUserId());


        // 使用流创建UserRoleEntity对象
        List<UserRoleEntity> userRoleEntities = inputDTO.getRoleIds()
                .stream()
                .map(roleId -> UserRoleEntity.builder()
                        .roleId(roleId)
                        .userId(inputDTO.getUserId())
                        .build())
                .toList();

        // 批量插入
        roleClient.addUserRoleByUserId(userRoleEntities);

        return true;
    }

    @Override
    public Boolean editUser(EditUserInputDTO inputDTO) {
        // 判断该用户id是否有效
        if (!userRepository.exists(
                Wrappers.<UserEntity>lambdaQuery().eq(UserEntity::getId, inputDTO.getId()))) {
            throw new UserFriendlyException("该用户不存在");
        }

        // 更新的数据
        UserEntity updateEntity = ModelMapperUtil.map(inputDTO, UserEntity.class);

        // 执行更新
        userRepository.updateById(updateEntity);

        return true;
    }

    @Override
    public Boolean setState(SetUserStateInputDTO inputDTO) {
        // 判断该用户id是否有效
        if (!userRepository.exists(
                Wrappers.<UserEntity>lambdaQuery().eq(UserEntity::getId, inputDTO.getId()))) {
            throw new UserFriendlyException("该用户不存在");
        }
        // 更新对象
        UserEntity updateEntity = UserEntity.builder()
                .enable(inputDTO.getState())
                .build();
        updateEntity.setId(inputDTO.getId());

        userRepository.updateById(updateEntity);
        return true;
    }

    @Override
    public List<UserVO> queryOnlineUser(UserQueryPageInputDTO inputDTO) {
        // 获取在线用户ID列表
        List<Long> onlineUserIdList = onlineUserClient.getOnlineUserIdList();
        // 无在线用户id列表 返回空
        if (CollectionUtil.isEmpty(onlineUserIdList)) {
            return List.of();
        }
        // 查询库
        List<UserEntity> userEntityList = userRepository.selectList(new LambdaQueryWrapper<UserEntity>().in(UserEntity::getId, onlineUserIdList));
        // 转换为VO
        return userConverter.toVOList(userEntityList);
    }

    @Override
    public Boolean changeAvatar(ChangeAvatarInputDTO inputDTO) {
        // 判断该用户id是否有效
        if (!userRepository.exists(
                Wrappers.<UserEntity>lambdaQuery().eq(UserEntity::getId, inputDTO.getId()))) {
            throw new UserFriendlyException("该用户不存在");
        }
        // 更新对象
        UserEntity updateEntity = UserEntity.builder()
                .avatarUrl(inputDTO.getAvatarUrl())
                .build();
        updateEntity.setId(inputDTO.getId());

        userRepository.updateById(updateEntity);
        return true;
    }
}
