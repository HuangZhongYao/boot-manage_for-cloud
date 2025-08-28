package org.github.bm.system.service.impl;

import jakarta.annotation.Resource;
import org.github.bm.system.service.INotificationsService;
import org.github.bm.system.service.INotificationsTargetService;
import org.springframework.stereotype.Service;

/**
 * Time 2025-08-28 17:12
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Service
public class NotificationsServiceImpl implements INotificationsService {

    @Resource
    private INotificationsTargetService notificationsTargetService;
}
