package org.github.bm.system.feign.fallback;

import org.github.bm.system.entity.NotificationsRecordEntity;
import org.github.bm.system.feign.INotificationsClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Time 2025-09-08 15:57
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Component
public class NotificationsClientFallback implements INotificationsClient {
    @Override
    public Integer addNotificationsRecord(List<NotificationsRecordEntity> notificationsRecordEntityList) {
        return 0;
    }
}
