package org.github.bm.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.github.bm.common.base.vo.BaseIdAndTimeAndOperationIdVO;
import org.github.bm.system.dto.NotificationsTargetInputDTO;
import org.github.bm.system.enums.NotificationsStateEnum;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Time 2025-08-28 16:40
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class NotificationsVO extends BaseIdAndTimeAndOperationIdVO {
    /**
     * 标题
     */
    @Schema(description = "标题")
    private String title;

    /**
     * 内容
     */
    @Schema(description = "内容")
    private String content;

    /**
     * 状态
     */
    @Schema(description = "状态")
    private NotificationsStateEnum state;

    /**
     * 状态描述
     */
    @Schema(description = "状态描述")
    private String stateDesc;

    /**
     * 发布时间
     */
    @Schema(description = "发布时间")
    private LocalDateTime publishTime;

    /**
     * 撤回时间
     */
    @Schema(description = "撤回时间")
    private LocalDateTime revokeTime;

    /**
     * 通知目标
     */
    @Schema(description = "通知目标")
    private List<NotificationsTargetInputDTO> notificationsTargets;

    public String getStateDesc() {
        if (state == null) {
            return null;
        }
        return state.desc;
    }
}
