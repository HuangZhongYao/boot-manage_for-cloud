package org.github.bm.system.web;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.github.bm.common.base.web.BaseController;
import org.github.bm.system.service.INotificationsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Time 2025-08-28 17:13
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Tag(name = "通知管理")
@RequestMapping("/notifications")
@RestController
public class NotificationsController extends BaseController {
    @Resource
    private INotificationsService notificationsService;
}
