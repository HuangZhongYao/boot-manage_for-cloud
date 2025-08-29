package org.github.bm.system.dto;

import lombok.*;
import org.github.bm.common.base.dto.BaseDTO;
import org.github.bm.common.validate.ValidateNotNullAndEmpty;
import org.github.bm.system.enums.NotificationsTargetEnum;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class NotificationsTargetInputDTO extends BaseDTO {
    /**
     * 通知目标类型
     */
    @ValidateNotNullAndEmpty(message = "通知目标类型不能为空")
    private NotificationsTargetEnum notificationsTarget;

    /**
     * 通知目标Id json数组
     */
    @ValidateNotNullAndEmpty(message = "通知目标Id不能为空")
    private String notificationsTargetId;
}
