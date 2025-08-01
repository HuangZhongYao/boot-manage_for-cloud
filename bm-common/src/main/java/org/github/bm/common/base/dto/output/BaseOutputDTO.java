package org.github.bm.common.base.dto.output;

import io.swagger.v3.oas.annotations.media.Schema;
import org.github.bm.common.base.dto.BaseDTO;

import java.io.Serial;

/**
 * @Desc baseOutputDTO 基类
 * @Time 2024-07-12 10:41
 * @Author HuangZhongYao
 */
public class BaseOutputDTO extends BaseDTO {

    @Serial
    private static final long serialVersionUID = -8243192684166209735L;


    public BaseOutputDTO() {
    }

    public BaseOutputDTO(Long id) {
        this.id = id;
    }

    @Schema(name = "id",description = "id字段",requiredMode = Schema.RequiredMode.REQUIRED,example = "1092327965422")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
