package org.github.bm.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.github.bm.common.base.dto.input.BaseLongIdInputDTO;
import org.github.bm.common.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.common.exception.UserFriendlyException;
import org.github.bm.system.converter.NotificationsConverter;
import org.github.bm.system.dto.AddNotificationsInputDTO;
import org.github.bm.system.dto.EditNotificationsInputDTO;
import org.github.bm.system.dto.NotificationsPageQueryInputDTO;
import org.github.bm.system.dto.NotificationsTargetInputDTO;
import org.github.bm.system.entity.NotificationsEntity;
import org.github.bm.system.entity.NotificationsRecordEntity;
import org.github.bm.system.entity.NotificationsTargetEntity;
import org.github.bm.system.enums.NotificationsStateEnum;
import org.github.bm.system.enums.NotificationsTargetEnum;
import org.github.bm.system.repository.NotificationsRepository;
import org.github.bm.system.service.*;
import org.github.bm.system.vo.NotificationsVO;
import org.github.bm.system.vo.RoleUserModel;
import org.github.bm.user.feign.IUserClient;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Time 2025-08-28 17:12
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Service
public class NotificationsServiceImpl extends ServiceImpl<NotificationsRepository, NotificationsEntity> implements INotificationsService {

    @Resource
    private IUserClient userClient;
    @Resource
    private IOrganizationService organizationService;
    @Resource
    private IRoleService roleService;
    @Resource
    private INotificationsTargetService notificationsTargetService;
    @Resource
    private NotificationsConverter notificationsConverter;
    @Resource
    private INotificationsRecordService notificationsRecordService;

    @Override
    public Page<NotificationsVO> pageQueryList(NotificationsPageQueryInputDTO inputDTO) {
        // 构建查询条件
        LambdaQueryWrapper<NotificationsEntity> queryWrapper = Wrappers.<NotificationsEntity>lambdaQuery()
                .orderByDesc(NotificationsEntity::getCreatedTime)
                .eq(null != inputDTO.getState(), NotificationsEntity::getState, inputDTO.getState())
                .like(StrUtil.isNotBlank(inputDTO.getKeyword()), NotificationsEntity::getTitle, inputDTO.getKeyword())
                .between(null != inputDTO.getBeginTime() && null != inputDTO.getEndTime(), NotificationsEntity::getPublishTime, inputDTO.getBeginTime(), inputDTO.getEndTime());
        // 执行查询
        Page<NotificationsEntity> page = this.baseMapper.selectPage(inputDTO.toMybatisPageObject(), queryWrapper);

        // 构建VO
        Page<NotificationsVO> pageVO = new Page<>();
        BeanUtils.copyProperties(page, pageVO);
        pageVO.setRecords(notificationsConverter.toNotificationsListVO(page.getRecords()));
        return pageVO;
    }

    @Override
    @Transactional
    public Boolean addNotifications(AddNotificationsInputDTO inputDTO) {
        // dto转换实体
        NotificationsEntity notificationsEntity = notificationsConverter.toEntity(inputDTO);
        // 设置状态为草稿
        notificationsEntity.setState(NotificationsStateEnum.DRAFT);
        // 插入
        this.baseMapper.insert(notificationsEntity);
        // 通知目标列表
        List<NotificationsTargetInputDTO> notificationsTargetDTOList = inputDTO.getNotificationsTargetDTOList();
        // 判断是否为空
        if (notificationsTargetDTOList.isEmpty()) {
            throw new UserFriendlyException("请选择通知目标");
        }
        // 通知目标实体对象列表
        List<NotificationsTargetEntity> notificationsTargetEntityList = new ArrayList<>(5);
        // 通知目标跟据类型分组
        Map<NotificationsTargetEnum, List<NotificationsTargetInputDTO>> notificationsTargetTypeMap = notificationsTargetDTOList.stream().collect(Collectors.groupingBy(NotificationsTargetInputDTO::getType));
        notificationsTargetTypeMap.forEach((key, value) -> {
            NotificationsTargetEntity notificationsTargetEntity = NotificationsTargetEntity
                    .builder()
                    .notificationsId(notificationsEntity.getId())
                    .notificationsTarget(key)
                    .notificationsTargetId(JSON.toJSONString(value.stream().map(item -> item.getId().toString()).toList()))
                    .notificationsTargetName(JSON.toJSONString(value.stream().map(NotificationsTargetInputDTO::getName).toList()))
                    .build();
            notificationsTargetEntityList.add(notificationsTargetEntity);
        });

        // 批量保存通知目标实体列表
        notificationsTargetService.saveBatch(notificationsTargetEntityList);

        return true;
    }

    @Override
    @Transactional
    public Boolean editNotifications(EditNotificationsInputDTO inputDTO) {
        // dto转换实体
        NotificationsEntity notificationsEntity = notificationsConverter.toEntity(inputDTO);
        // 插入
        this.baseMapper.updateById(notificationsEntity);
        // 通知目标列表
        List<NotificationsTargetInputDTO> notificationsTargetDTOList = inputDTO.getNotificationsTargetDTOList();
        // 判断是否为空
        if (notificationsTargetDTOList.isEmpty()) {
            throw new UserFriendlyException("请选择通知目标");
        }
        // 通知目标实体对象列表
        List<NotificationsTargetEntity> notificationsTargetEntityList = new ArrayList<>(5);
        // 通知目标跟据类型分组
        Map<NotificationsTargetEnum, List<NotificationsTargetInputDTO>> notificationsTargetTypeMap = notificationsTargetDTOList.stream().collect(Collectors.groupingBy(NotificationsTargetInputDTO::getType));
        notificationsTargetTypeMap.forEach((key, value) -> {
            NotificationsTargetEntity notificationsTargetEntity = NotificationsTargetEntity
                    .builder()
                    .notificationsId(notificationsEntity.getId())
                    .notificationsTarget(key)
                    .notificationsTargetId(JSON.toJSONString(value.stream().map(item -> item.getId().toString()).toList()))
                    .notificationsTargetName(JSON.toJSONString(value.stream().map(NotificationsTargetInputDTO::getName).toList()))
                    .build();
            notificationsTargetEntityList.add(notificationsTargetEntity);
        });
        // 保存之前先清除
        notificationsTargetService.getBaseMapper().delete(Wrappers.<NotificationsTargetEntity>lambdaQuery().eq(NotificationsTargetEntity::getNotificationsId, notificationsEntity.getId()));
        // 批量保存通知目标实体列表
        notificationsTargetService.saveBatch(notificationsTargetEntityList);
        return true;
    }

    @Override
    public Boolean delNotifications(BaseManyLongIdInputDTO inputDTO) {
        return this.baseMapper.deleteByIds(inputDTO.getIds()) > 0;
    }

    @Override
    @Transactional
    public Boolean publish(BaseLongIdInputDTO inputDTO) {

        NotificationsEntity notificationsEntity = this.getBaseMapper().selectById(inputDTO.getId());

        // 验证是否id是否有效
        if (null == notificationsEntity) {
            throw new UserFriendlyException("该通知不存在");
        }
        // 验证是否已发布
        if (NotificationsStateEnum.PUBLISHED.equals(notificationsEntity.getState())) {
            throw new UserFriendlyException("该通知已发布");
        }

        NotificationsEntity updateEntity = new NotificationsEntity();
        updateEntity.setId(inputDTO.getId());
        updateEntity.setState(NotificationsStateEnum.PUBLISHED);
        updateEntity.setPublishTime(LocalDateTime.now());

        // 通知用户列表
        Set<Long> targetUserIdSet = new HashSet<>(100);

        // 获取通知目标列表
        List<NotificationsTargetEntity> notificationsTargetEntityList = this.notificationsTargetService.list(Wrappers.<NotificationsTargetEntity>lambdaQuery().eq(NotificationsTargetEntity::getNotificationsId, inputDTO.getId()));
        // 通知目标根据类型分组
        Map<NotificationsTargetEnum, List<NotificationsTargetEntity>> notificationsTargetTypeMap = notificationsTargetEntityList.stream().collect(Collectors.groupingBy(NotificationsTargetEntity::getNotificationsTarget));
        // 类型分组获取通知用户Id集合
        notificationsTargetTypeMap.forEach((key, value) -> {

            // 通知目标Id集合
            Set<Long> targetIdSet = value.stream()
                    .filter(item -> StrUtil.isNotBlank(item.getNotificationsTargetId()))
                    .map(item -> JSON.parseArray(item.getNotificationsTargetId(), Long.class))
                    .flatMap(List::stream)
                    .collect(Collectors.toSet());

            // 根据类型获取通知用户Id集合
            switch (key) {
                case USER:
                    targetUserIdSet.addAll(targetIdSet);
                    break;
                case ROLE:
                    // 获取角色用户列表
                    List<RoleUserModel> roleUserModelList = roleService.queryRoleUserList(targetIdSet.stream().toList());
                    if (!roleUserModelList.isEmpty()) {
                        targetUserIdSet.addAll(roleUserModelList.stream().map(RoleUserModel::getId).collect(Collectors.toSet()));
                    }
                case ORGANIZATION:
                    // 获取组织下用户Id列表
                    List<Long> organizationUserIdList = organizationService.queryOrganizationUserIdListByIds(targetIdSet.stream().toList());
                    targetUserIdSet.addAll(organizationUserIdList);
                    break;
                case ALL:
                    List<Long> allUserIdList = userClient.getAllUserIdList();
                    targetUserIdSet.addAll(allUserIdList);
                    break;
                default:
                    break;
            }
        });

        // 构建通知记录实体
        List<NotificationsRecordEntity> notificationsRecordEntityList = targetUserIdSet.stream()
                .map(userId -> NotificationsRecordEntity.builder()
                        .notificationsId(inputDTO.getId())
                        .userId(userId)
                        .read(false)
                        .build())
                .toList();
        // 批量插入通知记录数据
        notificationsRecordService.saveBatch(notificationsRecordEntityList);

        return this.updateById(updateEntity);
    }
}
