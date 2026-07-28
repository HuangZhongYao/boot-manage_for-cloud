package org.github.bm.base.base.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;

/**
 * 包含id字段的VO
 *
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

    @Schema(name = "id", description = "id字段", requiredMode = Schema.RequiredMode.REQUIRED, example = "1092327965422")
    // @JsonSerialize(using = ToStringSerializer.class)  因为使用雪花id长度超过JavaScript 数字精度限制,所以将id序列号为string. 由于在消息转换器中统一配置了所以这里注释掉
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
