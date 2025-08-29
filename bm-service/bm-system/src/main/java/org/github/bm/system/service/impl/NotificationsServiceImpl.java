package org.github.bm.system.service.impl;

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
import org.github.bm.system.entity.NotificationsTargetEntity;
import org.github.bm.system.enums.NotificationsStateEnum;
import org.github.bm.system.repository.NotificationsRepository;
import org.github.bm.system.service.INotificationsService;
import org.github.bm.system.service.INotificationsTargetService;
import org.github.bm.system.vo.NotificationsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Time 2025-08-28 17:12
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Service
public class NotificationsServiceImpl extends ServiceImpl<NotificationsRepository, NotificationsEntity> implements INotificationsService {

    @Resource
    private INotificationsTargetService notificationsTargetService;
    @Resource
    private NotificationsConverter notificationsConverter;

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
        // 转换为通知目标实体对象列表
        List<NotificationsTargetEntity> notificationsTargetEntityList = notificationsConverter.toNotificationsTargetEntityList(notificationsTargetDTOList);
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
        // 转换为通知目标实体对象列表
        List<NotificationsTargetEntity> notificationsTargetEntityList = notificationsConverter.toNotificationsTargetEntityList(notificationsTargetDTOList);
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
    public Boolean publish(BaseLongIdInputDTO inputDTO) {
        NotificationsEntity updateEntity = new NotificationsEntity();
        updateEntity.setId(inputDTO.getId());
        updateEntity.setState(NotificationsStateEnum.PUBLISHED);
        updateEntity.setPublishTime(LocalDateTime.now());
        return this.updateById(updateEntity);
    }
}
