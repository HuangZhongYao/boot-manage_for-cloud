package org.github.bm.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.*;
import org.github.bm.common.base.dto.BaseDTO;
import org.github.bm.common.validate.ValidateNotNullAndEmpty;
import org.github.bm.system.enums.NotificationsTargetEnum;
import org.springframework.validation.annotation.Validated;

import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Validated
public class NotificationsTargetInputDTO extends BaseDTO {
    /**
     * 通知目标id
     */
    @ValidateNotNullAndEmpty(message = "通知目标id不能为空")
    @Schema(description = "通知目标id")
    private Long id;
    /**
     * 通知目标类型
     */
    @ValidateNotNullAndEmpty(message = "通知目标类型不能为空")
    @Schema(description = "通知目标类型")
    private NotificationsTargetEnum type;

    /**
     * 通知目标名称
     */
    @ValidateNotNullAndEmpty(message = "通知目标名称不能为空")
    @Schema(description = "通知目标名称")
    private String name;
}
