package org.github.bm.system.dto;

import lombok.*;
import org.github.bm.common.base.vo.BaseIdVO;
import org.github.bm.common.validate.ValidateNotNullAndEmpty;

import java.util.List;


@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class EditNotificationsInputDTO extends BaseIdVO {

    @ValidateNotNullAndEmpty(message = "标题不能为空")
    private String title;

    @ValidateNotNullAndEmpty(message = "内容不能为空")
    private String content;

    @ValidateNotNullAndEmpty(message = "通知目标不能为空")
    private List<NotificationsTargetInputDTO> notificationsTargets;
}
