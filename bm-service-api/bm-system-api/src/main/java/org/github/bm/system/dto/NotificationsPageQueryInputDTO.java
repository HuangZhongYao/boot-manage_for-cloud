package org.github.bm.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.github.bm.common.base.dto.input.BaseQueryPageInputDTO;
import org.github.bm.system.enums.NotificationsStateEnum;

@Data
@EqualsAndHashCode(callSuper = true)
public class NotificationsPageQueryInputDTO extends BaseQueryPageInputDTO {

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private NotificationsStateEnum state;
}
