package org.github.bm.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.github.bm.common.base.dto.BaseDTO;

import java.io.Serial;
import java.util.Set;

/**
 * @Desc: Created by IntelliJ IDEA.
 * @Author: ZhongYao.Huang
 * @Copyright: ZuuuuYao By Github
 * @Time: 2024-07-21 16:56
 */
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SetRoleUserInputDTO extends BaseDTO {

    @Serial
    private static final long serialVersionUID = 3151865599208537313L;

    @Schema(description = "角色Id")
    public Long roleId;

    @Schema(description = "用户Id集合")
    public Set<Long> userIds;
}
