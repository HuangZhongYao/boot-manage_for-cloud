package org.github.bm.system.feign;

import org.github.bm.common.base.fegin.BaseFeign;
import org.github.bm.common.constant.AppConstant;
import org.github.bm.system.entity.NotificationsRecordEntity;
import org.github.bm.system.feign.fallback.NotificationsClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Time 2025-09-08 15:55
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@FeignClient(value = AppConstant.APPLICATION_SYSTEM_NAME, contextId = "notificationsRecordClient", fallback = NotificationsClientFallback.class)
public interface INotificationsClient extends BaseFeign {

    /**
     * API基础路径前缀
     */
    String API_PREFIX = BASE_API_PREFIX + "/notifications";

    /**
     * 添加通知记录接口路径
     */
    String ADD_NOTIFICATIONS_RECORD = API_PREFIX + "/addNotificationsRecord";

    /**
     * 批量添加通知记录
     *
     * @param notificationsRecordEntityList 通知记录实体列表
     * @return 添加成功的记录数
     */
    @PostMapping(ADD_NOTIFICATIONS_RECORD)
    Integer addNotificationsRecord(@RequestBody List<NotificationsRecordEntity> notificationsRecordEntityList);
}

