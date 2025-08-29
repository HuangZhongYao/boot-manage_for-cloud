package org.github.bm.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.github.bm.common.base.dto.input.BaseQueryPageInputDTO;
import org.github.bm.system.entity.RoleEntity;

import java.io.Serial;

/**
 * @Desc: Created by IntelliJ IDEA.
 * @Author: ZhongYao.Huang
 * @Copyright: ZuuuuYao By Github
 * @Time: 2024-07-16 21:02
 */
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RolePageQueryInputDTO extends BaseQueryPageInputDTO {

    @Serial
    private static final long serialVersionUID = 4631897722110504328L;

    @Schema(description = "角色名")
    private String name;

    @Schema(description = "启用状态")
    private Boolean enable;
}
