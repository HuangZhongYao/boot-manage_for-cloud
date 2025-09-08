package org.github.bm.system.feign;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.annotation.Resource;
import org.github.bm.system.entity.NotificationsRecordEntity;
import org.github.bm.system.service.INotificationsRecordService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Time 2025-09-08 16:01
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Hidden
@RestController
public class NotificationsRecordClient implements INotificationsRecordClient {
    @Resource
    private INotificationsRecordService notificationsRecordService;

    @Override
    @PostMapping(ADD_NOTIFICATIONS_RECORD)
    public Integer addNotificationsRecord(@RequestBody List<NotificationsRecordEntity> notificationsRecordEntityList) {
        return notificationsRecordService.saveBatch(notificationsRecordEntityList) ? notificationsRecordEntityList.size() : 0;
    }
}
