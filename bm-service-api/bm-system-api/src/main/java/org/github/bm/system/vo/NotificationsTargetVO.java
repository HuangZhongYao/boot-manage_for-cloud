package org.github.bm.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.github.bm.common.base.vo.BaseIdAndTimeIdVO;
import org.github.bm.system.entity.NotificationsEntity;
import org.github.bm.system.enums.NotificationsTargetEnum;

/**
 * Time 2025-08-28 16:51
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class NotificationsTargetVO extends BaseIdAndTimeIdVO {

    /**
     * NotificationsEntity 主表 id {@link NotificationsEntity#id}
     */
    @Schema(description = "通知id")
    private Long notificationsId;

    /**
     * 通知目标id
     */
    @Schema(description = "通知目标id")
    private Long id;
    /**
     * 通知目标类型
     */
    @Schema(description = "通知目标类型")
    private NotificationsTargetEnum type;

    /**
     * 通知目标名称
     */
    @Schema(description = "通知目标名称")
    private String name;

}
