package org.github.bm.system.repository;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.github.bm.base.mybatis.BaseMapperExtension;
import org.github.bm.system.entity.NotificationsRecordEntity;
import org.github.bm.system.vo.NotificationsRecordVO;
import org.springframework.stereotype.Repository;

/**
 * Time 2025-08-28 17:25
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Repository
public interface NotificationsRecordRepository extends BaseMapperExtension<NotificationsRecordEntity> {
    /**
     * 查询我的通知记录
     * @param page 分页对象
     * @param userId 用户id
     * @return Page<通知记录>
     */
    Page<NotificationsRecordVO> queryMyNotificationRecords(@Param("page") Page page,@Param("userId") Long userId);

    /**
     * 查询未读通知数量
     * @param userId 用户id
     * @return Long
     */
    Long countUnreadNotifications(@Param("userId") Long userId);
}
