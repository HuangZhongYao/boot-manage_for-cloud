package org.github.bm.common.base.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import org.github.bm.common.base.dto.BaseDTO;

import java.io.Serial;

/**
 * 包含id字段的VO
 * @Desc BaseIdVO 基类
 * @Time 2024-07-12 10:41
 * @Author HuangZhongYao
 */
public class BaseIdVO extends BaseVO {

    @Serial
    private static final long serialVersionUID = -8243192684166209735L;


    public BaseIdVO() {
    }

    public BaseIdVO(Long id) {
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
