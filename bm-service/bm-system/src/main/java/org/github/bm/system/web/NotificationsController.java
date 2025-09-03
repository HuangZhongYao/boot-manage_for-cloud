package org.github.bm.system.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.github.bm.common.base.dto.input.BaseLongIdInputDTO;
import org.github.bm.common.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.common.base.dto.input.BaseQueryPageInputDTO;
import org.github.bm.common.base.response.ApiResponse;
import org.github.bm.common.base.web.BaseController;
import org.github.bm.system.dto.*;
import org.github.bm.system.service.INotificationsRecordService;
import org.github.bm.system.service.INotificationsService;
import org.github.bm.system.vo.NotificationsRecordVO;
import org.github.bm.system.vo.NotificationsVO;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 通知公告控制器
 * Time 2025-08-28 17:13
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Tag(name = "通知公告接口")
@RequestMapping("/notifications")
@RestController
public class NotificationsController extends BaseController {
    @Resource
    private INotificationsService notificationsService;
    @Resource
    private INotificationsRecordService notificationsRecordService;

    @Operation(summary = "分页查询我的通知记录", description = "分页查询通知公告接口")
    @GetMapping(value = "/queryMyNotificationRecords", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Page<NotificationsRecordVO>> queryMyNotificationRecords(BaseQueryPageInputDTO inputDTO) {
        return ApiResponse.ok(notificationsRecordService.queryMyNotificationRecords(inputDTO));
    }

    @Operation(summary = "已读通知记录")
    @PatchMapping(value = "/readNotificationRecords", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> readNotificationRecords(@RequestBody @Validated ReadNotificationRecordsInputDTO inputDTO) {
        return ApiResponse.ok(notificationsRecordService.readNotificationRecords(inputDTO));
    }

    @Operation(summary = "删除通知记录")
    @DeleteMapping(value = "/delNotificationRecord", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> delNotificationRecord(@RequestBody @Validated DelNotificationRecordsInputDTO inputDTO) {
        return ApiResponse.ok(notificationsRecordService.delNotificationRecord(inputDTO));
    }

    @Operation(summary = "分页查询通知公告", description = "分页查询通知公告接口")
    @GetMapping(value = "/pageQueryList", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperationSupport(authors = "zuuuYao")
    public ApiResponse<Page<NotificationsVO>> pageQueryList(NotificationsPageQueryInputDTO inputDTO) {
        return ApiResponse.ok(notificationsService.pageQueryList(inputDTO));
    }

    @Operation(summary = "添加通知公告", description = "添加通知公告接口")
    @PostMapping(value = "/addNotifications", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> addNotifications(@RequestBody @Validated AddNotificationsInputDTO inputDTO) {
        return ApiResponse.ok(notificationsService.addNotifications(inputDTO));
    }

    @Operation(summary = "编辑通知公告", description = "编辑通知公告接口")
    @PatchMapping(value = "/editNotifications", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> editNotifications(@RequestBody @Validated EditNotificationsInputDTO inputDTO) {
        return ApiResponse.ok(notificationsService.editNotifications(inputDTO));
    }

    @Operation(summary = "删除通知公告")
    @DeleteMapping(value = "/delNotifications", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> delNotifications(@RequestBody @Validated BaseManyLongIdInputDTO inputDTO) {
        return ApiResponse.ok(notificationsService.delNotifications(inputDTO));
    }

    @Operation(summary = "发布通知公告", description = "发布通知公告接口")
    @PatchMapping(value = "/publish", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> publish(@RequestBody @Validated BaseLongIdInputDTO inputDTO) {
        return ApiResponse.ok(notificationsService.publish(inputDTO));
    }
}
