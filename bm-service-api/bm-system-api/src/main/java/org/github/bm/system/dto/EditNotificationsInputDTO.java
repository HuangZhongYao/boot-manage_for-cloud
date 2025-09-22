package org.github.bm.system.dto;

import lombok.*;
import org.github.bm.common.base.vo.BaseIdVO;
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
public class EditNotificationsInputDTO extends BaseIdVO {

    @ValidateNotNullAndEmpty(message = "通知类型不能为空")
    private NotificationsTypeEnum type;

    @ValidateNotNullAndEmpty(message = "通知级别不能为空")
    private NotificationsLevelEnum level;

    @ValidateNotNullAndEmpty(message = "是否全体通知不能为空")
    private Boolean allNotifications;

    @ValidateNotNullAndEmpty(message = "标题不能为空")
    private String title;

    @ValidateNotNullAndEmpty(message = "内容不能为空")
    private String content;

    @ValidateNotNullAndEmpty(message = "通知目标不能为空")
    private List<NotificationsTargetInputDTO> notificationsTargets;
}
