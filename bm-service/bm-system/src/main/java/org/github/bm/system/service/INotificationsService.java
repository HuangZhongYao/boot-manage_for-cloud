package org.github.bm.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.github.bm.base.base.dto.input.BaseLongIdInputDTO;
import org.github.bm.base.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.system.dto.AddNotificationsInputDTO;
import org.github.bm.system.dto.EditNotificationsInputDTO;
import org.github.bm.system.dto.NotificationsPageQueryInputDTO;
import org.github.bm.system.entity.NotificationsEntity;
import org.github.bm.system.vo.NotificationsVO;

/**
 * Time 2025-08-28 17:10
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
public interface INotificationsService extends IService<NotificationsEntity> {

    /**
     * 分页查询通知公告列表
     * @param inputDTO 分页查询通知公告列表输入参数对象，包含分页信息
     * @return Page<NotificationsVO> 分页查询结果，包含通知公告列表
     */
    Page<NotificationsVO> pageQueryList(NotificationsPageQueryInputDTO inputDTO);

    /**
     * 添加通知公告
     * @param inputDTO 添加通知公告输入参数对象，包含通知公告的基本信息
     * @return Boolean 添加结果，true表示添加成功，false表示添加失败
     */
    Boolean addNotifications(AddNotificationsInputDTO inputDTO);

    /**
     * 编辑通知公告
     * @param inputDTO 编辑通知公告输入参数对象，包含要修改的通知公告信息
     * @return Boolean 编辑结果，true表示编辑成功，false表示编辑失败
     */
    Boolean editNotifications(EditNotificationsInputDTO inputDTO);

    /**
     * 删除通知公告
     * @param inputDTO 删除通知公告输入参数对象，包含要删除的通知公告ID列表
     * @return Boolean 删除结果，true表示删除成功，false表示删除失败
     */
    Boolean delNotifications(BaseManyLongIdInputDTO inputDTO);

    /**
     * 发布通知公告
     * @param inputDTO 发布通知公告输入参数对象，包含要发布的通知公告ID
     * @return Boolean 发布结果，true表示发布成功，false表示发布失败
     */
    Boolean publish(BaseLongIdInputDTO inputDTO);
}

