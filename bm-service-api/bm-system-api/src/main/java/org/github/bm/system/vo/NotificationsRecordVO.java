package org.github.bm.system.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.github.bm.common.base.vo.BaseIdAndTimeIdVO;
import org.github.bm.system.enums.NotificationsLevelEnum;
import org.github.bm.system.enums.NotificationsRecordBusinessTypeEnum;

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
     * 通知业务场景
     */
    @Schema(description = "通知业务场景类型")
    private NotificationsRecordBusinessTypeEnum businessType;

    /**
     * 通知业务场景关联业务Id
     */
    @Schema(description = "通知业务场景关联业务Id")
    private Long businessId;

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
     * 通知发布时间
     */
    @Schema(description = "通知发布时间")
    private LocalDateTime publishTime;

    /**
     * 通知级别
     */
    @Schema(description = "通知级别")
    private NotificationsLevelEnum level;
}
