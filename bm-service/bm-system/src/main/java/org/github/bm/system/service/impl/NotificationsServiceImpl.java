package org.github.bm.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
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
import org.github.bm.system.entity.NotificationsRecordContentEntity;
import org.github.bm.system.entity.NotificationsRecordEntity;
import org.github.bm.system.entity.NotificationsTargetEntity;
import org.github.bm.system.enums.NotificationsLevelEnum;
import org.github.bm.system.enums.NotificationsRecordBusinessTypeEnum;
import org.github.bm.system.enums.NotificationsStateEnum;
import org.github.bm.system.enums.NotificationsTargetEnum;
import org.github.bm.system.repository.NotificationsRecordContentRepository;
import org.github.bm.system.repository.NotificationsRepository;
import org.github.bm.system.service.*;
import org.github.bm.system.vo.NotificationsVO;
import org.github.bm.system.vo.RoleUserModel;
import org.github.bm.user.entity.UserEntity;
import org.github.bm.user.feign.IUserClient;
import org.github.bm.websocket.base.AbstractPayload;
import org.github.bm.websocket.base.MessageHandlerConstant;
import org.github.bm.websocket.base.WebSocketMessage;
import org.github.bm.websocket.dto.NotificationMessagePayloadDTO;
import org.github.bm.websocket.feign.IWebSocketClient;
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
    @Resource
    private IWebSocketClient webSocketClient;
    @Resource
    private NotificationsRecordContentRepository notificationsRecordContentRepository;

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
        //
        List<Long> idList = page.getRecords().stream().map(NotificationsEntity::getId).toList();
        // 查询子表通知目标列表
        List<NotificationsTargetEntity> notificationsTargetEntityList = notificationsTargetService.getBaseMapper().selectList(Wrappers.<NotificationsTargetEntity>lambdaQuery().in(NotificationsTargetEntity::getNotificationsId, idList));
        // 通知目标列表分组
        Map<Long, List<NotificationsTargetEntity>> notificationsTargetMap = notificationsTargetEntityList.stream().collect(Collectors.groupingBy(NotificationsTargetEntity::getNotificationsId));

        // 发布人Id列表
        List<Long> publisherIdList = page.getRecords().stream().map(NotificationsEntity::getPublisher).toList();

        // 构建VO
        Page<NotificationsVO> pageVO = new Page<>();
        BeanUtils.copyProperties(page, pageVO);
        pageVO.setRecords(notificationsConverter.toNotificationsListVO(page.getRecords()));

        if (CollectionUtil.isNotEmpty(publisherIdList)) {
            // 获取发布人
            List<UserEntity> createdByUserList = userClient.getUserByIDList(publisherIdList);
            // 发布人分组
            Map<Long, String> createdByUserMap = null == createdByUserList ? new HashMap<>() : createdByUserList.stream().collect(Collectors.toMap(UserEntity::getId, UserEntity::getUsername));
            // 赋值发布人属性
            pageVO.getRecords().forEach(item -> {
                String username = createdByUserMap.get(item.getCreatedBy());
                if (null != username) {
                    item.setPublisherName(username);
                }
            });
        }

        // 赋值通知目标属性
        for (NotificationsVO notificationsVO : pageVO.getRecords()) {
            List<NotificationsTargetEntity> targetEntityList = notificationsTargetMap.get(notificationsVO.getId());
            if (CollectionUtil.isNotEmpty(targetEntityList)) {
                List<NotificationsTargetInputDTO> notificationsTargetInputDTOList = targetEntityList.stream().map(item -> NotificationsTargetInputDTO.builder().id(item.getTargetId()).type(item.getTargetType()).name(item.getTargetName()).build()).toList();
                notificationsVO.setNotificationsTargets(notificationsTargetInputDTOList);
            }
        }

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
        List<NotificationsTargetInputDTO> notificationsTargetDTOList = inputDTO.getNotificationsTargets();
        // 判断是否为空
        if (Boolean.FALSE.equals(inputDTO.getAllNotifications()) && notificationsTargetDTOList.isEmpty()) {
            throw new UserFriendlyException("请选择通知目标");
        }
        // 通知目标实体对象列表
        List<NotificationsTargetEntity> notificationsTargetEntityList = null;
        if (inputDTO.getAllNotifications()) {
            notificationsTargetEntityList = new ArrayList<>(1);
            notificationsTargetEntityList.add(
                    NotificationsTargetEntity.builder()
                            .notificationsId(notificationsEntity.getId())
                            .targetType(NotificationsTargetEnum.ALL)
                            .targetId(null)
                            .targetName(NotificationsTargetEnum.ALL.getDesc())
                            .build()
            );
        } else {
            notificationsTargetEntityList = notificationsTargetDTOList
                    .stream()
                    .map(item ->
                            NotificationsTargetEntity.builder()
                                    .notificationsId(notificationsEntity.getId())
                                    .targetType(item.getType())
                                    .targetId(item.getId())
                                    .targetName(item.getName())
                                    .build()
                    )
                    .toList();
        }

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
        List<NotificationsTargetInputDTO> notificationsTargetDTOList = inputDTO.getNotificationsTargets();
        // 判断是否为空
        if (Boolean.FALSE.equals(inputDTO.getAllNotifications()) && notificationsTargetDTOList.isEmpty()) {
            throw new UserFriendlyException("请选择通知目标");
        }
        // 通知目标实体对象列表
        List<NotificationsTargetEntity> notificationsTargetEntityList = null;
        if (inputDTO.getAllNotifications()) {
            notificationsTargetEntityList = new ArrayList<>(1);
            notificationsTargetEntityList.add(
                    NotificationsTargetEntity.builder()
                            .notificationsId(notificationsEntity.getId())
                            .targetType(NotificationsTargetEnum.ALL)
                            .targetId(null)
                            .targetName(NotificationsTargetEnum.ALL.getDesc())
                            .build()
            );
        } else {
            notificationsTargetEntityList = notificationsTargetDTOList
                    .stream()
                    .map(item ->
                            NotificationsTargetEntity.builder()
                                    .notificationsId(notificationsEntity.getId())
                                    .targetType(item.getType())
                                    .targetId(item.getId())
                                    .targetName(item.getName())
                                    .build()
                    )
                    .toList();
        }
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
        // 查询库中的数据
        NotificationsEntity notificationsEntity = this.getBaseMapper().selectById(inputDTO.getId());
        // 验证是否id是否有效
        if (null == notificationsEntity) {
            throw new UserFriendlyException("该通知不存在");
        }
        // 验证是否是草稿状态
        if (!NotificationsStateEnum.DRAFT.equals(notificationsEntity.getState())) {
            throw new UserFriendlyException("该通知不是草稿状态不能发布");
        }

        // 通知用户列表
        Set<Long> targetUserIdSet = new HashSet<>(100);
        // 获取通知目标列表
        List<NotificationsTargetEntity> notificationsTargetEntityList = this.notificationsTargetService.list(Wrappers.<NotificationsTargetEntity>lambdaQuery().eq(NotificationsTargetEntity::getNotificationsId, inputDTO.getId()));
        // 通知目标根据类型分组
        Map<NotificationsTargetEnum, List<NotificationsTargetEntity>> notificationsTargetTypeMap = notificationsTargetEntityList.stream().collect(Collectors.groupingBy(NotificationsTargetEntity::getTargetType));
        // 类型分组获取通知用户Id集合
        notificationsTargetTypeMap.forEach((key, value) -> {

            // 通知目标Id集合
            Set<Long> targetIdSet = value.stream()
                    .map(NotificationsTargetEntity::getTargetId)
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

        // 通知内容实体
        NotificationsRecordContentEntity notificationsRecordContent = NotificationsRecordContentEntity.builder().title(notificationsEntity.getTitle()).content(notificationsEntity.getContent()).build();
        notificationsRecordContentRepository.insert(notificationsRecordContent);

        // 构建通知记录实体
        List<NotificationsRecordEntity> notificationsRecordEntityList = targetUserIdSet.stream()
                .map(userId -> NotificationsRecordEntity.builder()
                        .contentId(notificationsRecordContent.getId())
                        .businessId(notificationsEntity.getId())
                        .businessType(NotificationsRecordBusinessTypeEnum.NOTIFICATIONS)
                        .level(NotificationsLevelEnum.ORDINARY)
                        .userId(userId)
                        .readState(false)
                        .build())
                .toList();
        // 批量插入通知记录数据
        notificationsRecordService.saveBatch(notificationsRecordEntityList);
        // 构建更新实体
        NotificationsEntity updateEntity = new NotificationsEntity();
        updateEntity.setId(inputDTO.getId());
        updateEntity.setState(NotificationsStateEnum.PUBLISHED);
        updateEntity.setPublishTime(LocalDateTime.now());

        // websocket构建消息体
        NotificationMessagePayloadDTO payloadDTO = NotificationMessagePayloadDTO.builder()
                .title(notificationsEntity.getTitle())
                .content(notificationsEntity.getContent())
                .publishTime(notificationsEntity.getPublishTime())
                .level(notificationsEntity.getLevel())
                .businessId(notificationsEntity.getId())
                .businessType(NotificationsRecordBusinessTypeEnum.NOTIFICATIONS)
                .build();
        payloadDTO.setTitle(notificationsEntity.getTitle());
        payloadDTO.setFrom(AbstractPayload.DEFAULT_FROM);
        payloadDTO.setTo(new ArrayList<>(targetUserIdSet));
        payloadDTO.setTime(LocalDateTime.now());

        // 调用websocket模块推送消息
        if (Boolean.TRUE.equals(notificationsEntity.getAllNotifications())) {
            webSocketClient.sendPublicNotificationMessage(new WebSocketMessage<>(MessageHandlerConstant.NOTIFICATION_HANDLER_NAME, payloadDTO));
        } else {
            webSocketClient.sendNotificationMessage(new WebSocketMessage<>(MessageHandlerConstant.NOTIFICATION_HANDLER_NAME, payloadDTO));
        }

        // 更新状态
        return this.updateById(updateEntity);
    }
}
