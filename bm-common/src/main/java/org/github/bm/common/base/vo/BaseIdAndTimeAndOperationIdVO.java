package org.github.bm.common.base.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * @Desc 基础VO输出对象带id、时间操作人字段
 * @Time 2024-07-12 10:41
 * @Author HuangZhongYao
 */
public class BaseIdAndTimeAndOperationIdVO extends BaseIdAndTimeIdVO {

    @Serial
    private static final long serialVersionUID = -8243192684166209735L;


    public BaseIdAndTimeAndOperationIdVO() {
    }

    public BaseIdAndTimeAndOperationIdVO(String createdBy, String updatedBy) {
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public BaseIdAndTimeAndOperationIdVO(LocalDateTime createdTime, LocalDateTime updatedTime, String createdBy, String updatedBy) {
        super(createdTime, updatedTime);
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public BaseIdAndTimeAndOperationIdVO(Long id, LocalDateTime createdTime, LocalDateTime updatedTime, String createdBy, String updatedBy) {
        super(id, createdTime, updatedTime);
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    /**
     * 创建时间
     */
    @Schema(description = "创建人",name = "createdBy", example = "144344665")
    private String createdBy;

    /**
     * 更新时间
     */
    @Schema(description = "更新人",name = "updatedBy", example = "153344665")
    private String updatedBy;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
