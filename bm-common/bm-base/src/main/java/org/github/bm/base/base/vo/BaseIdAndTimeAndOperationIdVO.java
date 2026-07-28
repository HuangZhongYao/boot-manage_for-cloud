package org.github.bm.base.base.vo;

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

    public BaseIdAndTimeAndOperationIdVO(Long createdBy, String createdName, Long updatedBy, String updatedName) {
        this.createdBy = createdBy;
        this.createdName = createdName;
        this.updatedBy = updatedBy;
        this.updatedName = updatedName;
    }

    public BaseIdAndTimeAndOperationIdVO(LocalDateTime createdTime, LocalDateTime updatedTime, Long createdBy, String createdName, Long updatedBy, String updatedName) {
        super(createdTime, updatedTime);
        this.createdBy = createdBy;
        this.createdName = createdName;
        this.updatedBy = updatedBy;
        this.updatedName = updatedName;
    }

    public BaseIdAndTimeAndOperationIdVO(Long id, LocalDateTime createdTime, LocalDateTime updatedTime, Long createdBy, String createdName, Long updatedBy, String updatedName) {
        super(id, createdTime, updatedTime);
        this.createdBy = createdBy;
        this.createdName = createdName;
        this.updatedBy = updatedBy;
        this.updatedName = updatedName;
    }

    /**
     * 创建时间
     */
    @Schema(description = "创建人Id",name = "createdBy", example = "144344665")
    private Long createdBy;

    /**
     * 创建人名称
     */
    @Schema(description = "创建人名称",name = "createdName", example = "管理员")
    private String createdName;

    /**
     * 更新时间
     */
    @Schema(description = "更新人Id",name = "updatedBy", example = "153344665")
    private Long updatedBy;

    /**
     * 更新人名称
     */
    @Schema(description = "更新人名称",name = "updatedName", example = "管理员")
    private String updatedName;


    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedName() {
        return createdName;
    }

    public void setCreatedName(String createdName) {
        this.createdName = createdName;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedName() {
        return updatedName;
    }

    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName;
    }
}
