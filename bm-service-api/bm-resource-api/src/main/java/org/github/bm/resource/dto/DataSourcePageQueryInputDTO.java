package org.github.bm.resource.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.github.bm.common.base.dto.input.BaseQueryPageInputDTO;
import org.github.bm.resource.entity.DataSourceEntity;

public class DataSourcePageQueryInputDTO extends BaseQueryPageInputDTO<DataSourceEntity> {

    @Schema(description = "启用状态")
    private Boolean enable;
}
