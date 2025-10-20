package org.github.bm.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.github.bm.common.base.dto.input.BaseLongIdInputDTO;
import org.github.bm.common.validate.ValidateNotNullAndEmpty;

import java.io.Serial;

/**
 * Time 2025-10-20 09:32
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ChangeAvatarInputDTO extends BaseLongIdInputDTO {
    @Serial
    private static final long serialVersionUID = -233739729144636666L;

    @Schema(description = "头像url")
    @ValidateNotNullAndEmpty(message = "头像url")
    private String avatarUrl;

}
