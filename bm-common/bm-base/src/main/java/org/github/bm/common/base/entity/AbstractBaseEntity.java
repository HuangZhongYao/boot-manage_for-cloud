package org.github.bm.common.base.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serial;

/**
 * 抽象id和创建时间、更新时间、创建人、更新人实体类基类
 * @Desc: Created by IntelliJ IDEA.
 * @Author: ZhongYao.Huang
 * @Copyright: ZuuuuYao By Github
 * @Time: 2024-07-11 22:51
 */
public abstract class AbstractBaseEntity  extends AbstractIdAndTimeEntity{

    @Serial
    private static final long serialVersionUID = 7070481894407373661L;

    /**
     * 创建人
     */
    @TableField(value = "created_by",fill = FieldFill.INSERT)
    private Long createdBy;

    /**
     * 更新人
     */
    @TableField(value = "updated_by",fill = FieldFill.INSERT_UPDATE)
    private Long updatedBy;

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }
}
