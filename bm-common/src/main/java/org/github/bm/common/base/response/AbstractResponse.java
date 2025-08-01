package org.github.bm.common.base.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;
import java.io.Serializable;

/**
 * 接口响应包装类基类
 * @Desc
 * @Time 2024-07-12 16:03
 * @Author HuangZhongYao
 */
public abstract class AbstractResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 8628555509588883784L;

    /**
     * 响应码
     */
    @Schema(description = "响应码",example = "200")
    Integer code;

    /**
     * 响应信息
     */
    @Schema(description = "响应信息",example = "ok")
    String message;

    /**
     * 请求接口
     */
    @Schema(description = "请求接口")
    String path;

    /**
     * 处理结果
     */
    @Schema(description = "处理结果",example = "true")
    Boolean success;

    public AbstractResponse() {
    }

    public AbstractResponse(Integer code, String msg, String path, Boolean success) {
        this.code = code;
        this.message = msg;
        this.path = path;
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
