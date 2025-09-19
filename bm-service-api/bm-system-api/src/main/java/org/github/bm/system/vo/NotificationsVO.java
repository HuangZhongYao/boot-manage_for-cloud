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
     * 发布人id
     */
    @Schema(description = "发布人id")
    private Long publisher;

    /**
     * 发布人名称
     */
    @Schema(description = "发布人名称")
    private String publisherName;

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

    @Schema(description = "是否显示删除按钮")
    private Boolean showDelBtn;

    @Schema(description = "是否显示编辑按钮")
    private Boolean showEditBtn;

    @Schema(description = "是否显示发布按钮")
    private Boolean showPublishBtn;

    public String getStateDesc() {
        if (state == null) {
            return null;
        }
        return state.desc;
    }

    public Boolean getShowDelBtn() {
        if (state == null) {
            return false;
        }
        return state.equals(NotificationsStateEnum.DRAFT);
    }

    public Boolean getShowEditBtn() {
        if (state == null) {
            return false;
        }
        return state.equals(NotificationsStateEnum.DRAFT);
    }

    public Boolean getShowPublishBtn() {
        if (state == null) {
            return false;
        }
        return state.equals(NotificationsStateEnum.DRAFT);
    }
}
