package org.github.bm.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.github.bm.common.base.dto.BaseDTO;
import org.github.bm.common.validate.ValidateNotNullAndEmpty;
import org.github.bm.system.enums.NotificationsLevelEnum;
import org.github.bm.system.enums.NotificationsTypeEnum;

import java.util.List;


@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AddNotificationsInputDTO extends BaseDTO {

    @Schema(description = "通知类型枚举")
    @ValidateNotNullAndEmpty(message = "通知类型不能为空")
    private NotificationsTypeEnum type;

    @Schema(description = "通知级别枚举")
    @ValidateNotNullAndEmpty(message = "通知级别不能为空")
    private NotificationsLevelEnum level;

    @Schema(description = "是否全体通知")
    @ValidateNotNullAndEmpty(message = "是否全体通知不能为空")
    private Boolean allNotifications;

    @Schema(description = "标题")
    @ValidateNotNullAndEmpty(message = "标题不能为空")
    private String title;

    @Schema(description = "内容")
    @ValidateNotNullAndEmpty(message = "内容不能为空")
    private String content;

    @Schema(description = "通知目标")
    private List<NotificationsTargetInputDTO> notificationsTargets;
}
