package org.github.bm.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.github.bm.common.base.vo.BaseIdAndTimeIdVO;
import org.github.bm.system.entity.NotificationsEntity;
import org.github.bm.system.enums.NotificationsTargetEnum;

import java.util.List;

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
     * 通知目标类型
     */
    @Schema(description = "通知目标类型")
    private NotificationsTargetEnum notificationsTarget;

    /**
     * 通知目标Id json数组
     */
    @Schema(description = "通知目标Id json数组")
    private String notificationsTargetId;

    /**
     * 通知目标
     */
    @Schema(description = "通知目标列表")
    private List<NotificationsTargetLabelVO> notificationsTargetLabelList;

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class NotificationsTargetLabelVO{

        @Schema(description = "目标名称")
        private String name;

        @Schema(description = "目标Id")
        private String id;
    }
}
