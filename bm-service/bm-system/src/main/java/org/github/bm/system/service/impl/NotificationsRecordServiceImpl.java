package org.github.bm.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.github.bm.common.base.dto.input.BaseQueryPageInputDTO;
import org.github.bm.common.exception.UserFriendlyException;
import org.github.bm.common.security.SecurityContextHolder;
import org.github.bm.system.dto.DelNotificationRecordsInputDTO;
import org.github.bm.system.dto.ReadNotificationRecordsInputDTO;
import org.github.bm.system.entity.NotificationsRecordEntity;
import org.github.bm.system.repository.NotificationsRecordRepository;
import org.github.bm.system.service.INotificationsRecordService;
import org.github.bm.system.vo.NotificationsRecordVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Time 2025-08-28 17:27
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */

@Service
public class NotificationsRecordServiceImpl extends ServiceImpl<NotificationsRecordRepository, NotificationsRecordEntity> implements INotificationsRecordService {
    /**
     * 查询当前用户的通知记录
     *
     * @param inputDTO 查询参数
     * @return 分页通知记录
     */
    @Override
    public Page<NotificationsRecordVO> queryMyNotificationRecords(BaseQueryPageInputDTO inputDTO) {
        return this.baseMapper.queryMyNotificationRecords(inputDTO.toMybatisPageObject(), SecurityContextHolder.getAuthUserId());
    }

    /**
     * 已读全部通知记录
     *
     * @return 是否成功
     */
    @Override
    public Boolean readNotificationRecords(ReadNotificationRecordsInputDTO inputDTO) {
        // 输入参数校验
        if (inputDTO == null) {
            return false;
        }

        try {
            // 获取当前认证用户ID
            Long userId = SecurityContextHolder.getAuthUserId();

            // 验证用户ID有效性
            if (userId == null) {
                return false;
            }

            // 构建查询条件：当前用户的所有未读通知
            LambdaQueryWrapper<NotificationsRecordEntity> queryWrapper = Wrappers.<NotificationsRecordEntity>lambdaQuery()
                    .eq(NotificationsRecordEntity::getReadState, false)
                    .eq(NotificationsRecordEntity::getUserId, userId);

            // 操作的记录Id集合
            List<Long> ids = inputDTO.getIds();
            // 是否是全部已读
            Boolean readAll = inputDTO.getReadAll();

            // 如果不是全部标记为已读，则必须提供具体的ID列表
            if (Boolean.FALSE.equals(readAll)) {
                if (ids == null || ids.isEmpty()) {
                    throw new UserFriendlyException("id集合不能为空");
                }
                queryWrapper.in(NotificationsRecordEntity::getId, ids);
            }

            // 检查是否存在未读通知，避免无意义的更新操作
            long unreadCount = this.count(queryWrapper);
            if (unreadCount <= 0) {
                // 没有未读通知，视为操作成功
                return true;
            }

            // 构建更新实体
            NotificationsRecordEntity updateRecord = new NotificationsRecordEntity();
            updateRecord.setReadState(true);

            // 执行更新操作
            return this.update(updateRecord, queryWrapper);
        } catch (Exception e) {
            log.error("标记通知为已读时发生异常", e);
            return false;
        }
    }


    /**
     * 删除通知记录
     *
     * @param inputDTO 删除参数
     * @return 是否成功
     */
    @Override
    public Boolean delNotificationRecord(DelNotificationRecordsInputDTO inputDTO) {
        // 输入参数校验
        if (inputDTO == null) {
            return false;
        }

        try {
            // 获取当前认证用户ID
            Long userId = SecurityContextHolder.getAuthUserId();

            // 验证用户ID有效性
            if (userId == null) {
                return false;
            }

            // 构建查询条件：当前用户的所有未读通知
            LambdaQueryWrapper<NotificationsRecordEntity> deleteWrapper = Wrappers.<NotificationsRecordEntity>lambdaQuery()
                    .eq(NotificationsRecordEntity::getUserId, userId);

            // 操作的记录Id集合
            List<Long> ids = inputDTO.getIds();
            // 是否是全部删除
            Boolean delAll = inputDTO.getDelAll();

            // 如果不是全部删除，则必须提供具体的ID列表
            if (Boolean.FALSE.equals(delAll)) {
                if (ids == null || ids.isEmpty()) {
                    throw new UserFriendlyException("id集合不能为空");
                }
                deleteWrapper.in(NotificationsRecordEntity::getId, ids);
            }

            // 检查是否存在未读通知，避免无意义的更新操作
            long unreadCount = this.count(deleteWrapper);
            if (unreadCount <= 0) {
                // 没有通知，视为操作成功
                return true;
            }
            // 执行删除操作
            return this.remove(deleteWrapper);
        } catch (Exception e) {
            log.error("标记通知为已读时发生异常", e);
            return false;
        }
    }

    @Override
    public Long countUnreadNotifications() {
        // 获取当前认证用户ID
        Long userId = SecurityContextHolder.getAuthUserId();

        // 验证用户ID有效性
        if (userId == null) {
            return 0L;
        }
        return this.baseMapper.countUnreadNotifications(userId);
    }
}
