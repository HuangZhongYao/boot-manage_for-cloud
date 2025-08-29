package org.github.bm.resource.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.github.bm.common.base.dto.input.BaseQueryPageInputDTO;

public class DataSourcePageQueryInputDTO extends BaseQueryPageInputDTO {

    @Schema(description = "启用状态")
    private Boolean enable;
}
