package org.github.bm.resource.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.github.bm.common.base.entity.AbstractBaseEntity;
import org.github.bm.common.enums.DataSourceEnum;
/**
 * 数据源实体类
 */
@Getter
@Setter
@TableName("dev_datasource")
@AllArgsConstructor
@NoArgsConstructor
public class DataSourceEntity extends AbstractBaseEntity {
    /**
     * 数据源名称
     */
    private String name;
    /**
     * 数据源类型
     */
    private DataSourceEnum type;
    /**
     * 数据库驱动类名
     */
    private String driverClassName;
    /**
     * jdbc url
     */
    private String url;
    /**
     * 数据库用户名
     */
    private String username;
    /**
     * 数据库连接密码
     */
    private String password;
    /**
     * 是否启用
     */
    private Boolean enable;
}
