package org.github.bm.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.github.bm.base.base.dto.BaseDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Time 2025-09-02 15:41
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ReadNotificationRecordsInputDTO extends BaseDTO {

    @Schema(description = "id集合", example = "[1092327965422,12398293009,1092323556]")
    private List<Long> ids = new ArrayList<>();

    @Schema(description = "是否全部已读全部", example = "false")
    Boolean readAll;
}
