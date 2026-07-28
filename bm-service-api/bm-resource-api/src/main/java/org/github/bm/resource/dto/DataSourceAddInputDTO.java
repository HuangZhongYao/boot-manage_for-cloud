package org.github.bm.resource.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.github.bm.base.base.dto.BaseDTO;
import org.github.bm.base.enums.DataSourceEnum;
import org.github.bm.base.validate.ValidateNotNullAndEmpty;

@EqualsAndHashCode(callSuper = true)
@Data
public class DataSourceAddInputDTO extends BaseDTO {

    @Schema(description = "数据源名称")
    @ValidateNotNullAndEmpty(message = "数据源名称不能为空")
    private String name;

    @Schema(description = "数据源类型")
    @ValidateNotNullAndEmpty(message = "数据源类型不能为空")
    private DataSourceEnum type;

    @Schema(description = "数据库驱动类名")
    @ValidateNotNullAndEmpty(message = "数据库驱动类名不能为空")
    private String driverClassName;

    @Schema(description = "数据源url")
    @ValidateNotNullAndEmpty(message = "数据源url不能为空")
    private String url;

    @Schema(description = "数据库用户名")
    @ValidateNotNullAndEmpty(message = "数据库用户名不能为空")
    private String username;

    @Schema(description = "数据库连接密码")
    @ValidateNotNullAndEmpty(message = "数据库连接密码不能为空")
    private String password;

    @Schema(description = "启用状态")
    @ValidateNotNullAndEmpty(message = "启用状态不能为空")
    private Boolean enable;
}
