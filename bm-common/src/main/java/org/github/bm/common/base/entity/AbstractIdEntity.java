package org.github.bm.common.base.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serial;

/**
 * 抽象id实体类基类
 * @Desc: Created by IntelliJ IDEA.
 * @Author: ZhongYao.Huang
 * @Copyright: ZuuuuYao By Github
 * @Time: 2024-07-11 22:59
 */

public abstract class AbstractIdEntity implements IEntity{
    @Serial
    private static final long serialVersionUID = -1160371774869499257L;

    /**
     * 主键id
     */
    @TableId(value = "id",type = IdType.INPUT)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
