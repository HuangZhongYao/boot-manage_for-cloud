package org.github.bm.resource.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.github.bm.common.base.dto.BaseDTO;
import org.github.bm.common.base.vo.BaseIdAndTimeIdVO;
import org.github.bm.common.enums.DataSourceEnum;

@EqualsAndHashCode(callSuper = true)
@Data
public class DataSourceVO extends BaseIdAndTimeIdVO {
    /**
     * 数据源名称
     */
    @Schema(description = "数据源名称")
    private String name;
    /**
     * 数据源类型
     */
    @Schema(description = "数据源类型")
    private DataSourceEnum type;
    /**
     * 数据库驱动类名
     */
    @Schema(description = "数据库驱动类名")
    private String driverClassName;
    /**
     * 数据库用户名
     */
    @Schema(description = "数据库用户名")
    private String username;
    /**
     * 数据库连接密码
     */
    @Schema(description = "数据库连接密码")
    private String password;
}
