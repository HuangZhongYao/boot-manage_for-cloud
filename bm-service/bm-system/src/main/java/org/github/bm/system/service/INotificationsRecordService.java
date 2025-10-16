package org.github.bm.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.github.bm.common.base.dto.input.BaseQueryPageInputDTO;
import org.github.bm.system.dto.DelNotificationRecordsInputDTO;
import org.github.bm.system.dto.ReadNotificationRecordsInputDTO;
import org.github.bm.system.entity.NotificationsRecordEntity;
import org.github.bm.system.vo.NotificationsRecordVO;

/**
 * Time 2025-08-28 17:26
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
public interface INotificationsRecordService extends IService<NotificationsRecordEntity> {
    /**
     * 查询当前用户的通知记录
     *
     * @param inputDTO 查询参数
     * @return 分页通知记录
     */
    Page<NotificationsRecordVO> queryMyNotificationRecords(BaseQueryPageInputDTO inputDTO);

    /**
     * 已读通知记录
     *
     * @return 是否成功
     */
    Boolean readNotificationRecords(ReadNotificationRecordsInputDTO inputDTO);

    /**
     * 删除通知记录
     *
     * @param inputDTO 删除参数
     * @return 是否成功
     */
    Boolean delNotificationRecord(DelNotificationRecordsInputDTO inputDTO);

    /**
     * 查询未读通知数量
     * @return Long
     */
    Long countUnreadNotifications();
}
