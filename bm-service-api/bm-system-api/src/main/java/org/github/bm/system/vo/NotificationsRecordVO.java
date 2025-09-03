package org.github.bm.system.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.github.bm.common.base.vo.BaseIdAndTimeIdVO;
import org.github.bm.system.entity.NotificationsEntity;

import java.time.LocalDateTime;

/**
 * 通知记录VO
 * Time 2025-08-28 16:26
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_notifications_record")
public class NotificationsRecordVO extends BaseIdAndTimeIdVO {
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
     * NotificationsEntity 主表 id {@link NotificationsEntity#id}
     */
    @Schema(description = "通知表Id")
    private Long notificationsId;

    /**
     * 用户id {@link UserEntity#id}
     */
    @Schema(description = "用户id")
    private Long userId;

    /**
     * 用户名
     */
    @Schema(description = "通知用户用户名")
    private String username;

    /**
     * 读取状态
     */
    @Schema(description = "读取状态")
    private Boolean readState;

    /**
     * 阅读时间
     */
    @Schema(description = "阅读时间")
    private LocalDateTime readTime;

    /**
     * 通知公告发布时间
     */
    private LocalDateTime publishTime;
}
