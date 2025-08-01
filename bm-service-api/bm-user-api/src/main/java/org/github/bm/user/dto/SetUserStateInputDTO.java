package org.github.bm.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.github.bm.common.base.dto.input.BaseLongIdInputDTO;

import java.io.Serial;

/**
 * @Desc: Created by IntelliJ IDEA.
 * @Author: ZhongYao.Huang
 * @Copyright: ZuuuuYao By Github
 * @Time: 2024-07-25 22:50
 */
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SetUserStateInputDTO extends BaseLongIdInputDTO {

    @Serial
    private static final long serialVersionUID = -7374695140327319136L;

    @Schema(description = "状态")
    private Boolean state;
}
