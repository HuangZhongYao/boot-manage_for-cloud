package org.github.bm.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serial;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.github.bm.common.base.dto.output.BaseOutputIdAndTimeDTO;

/**
 * @Desc: Created by IntelliJ IDEA.
 * @Author: ZhongYao.Huang
 * @Copyright: ZuuuuYao By Github
 * @Time: 2024-07-15 21:40
 */
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RoleVo extends BaseOutputIdAndTimeDTO {

    @Serial
    private static final long serialVersionUID = 2264364149067433513L;

    /**
     * 图标
     */
    @Schema(description = "图标")
    private String icon;

    /**
     * 角色名称
     */
    @Schema(description = "角色名称")
    private String name;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;

    /**
     * 启用状态
     */
    @Schema(description = "启用状态")
    private Boolean enable;

    /**
     * 角色编码
     */
    @Schema(description = "角色编码")
    private String code;
}
