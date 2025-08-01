package org.github.bm.common.base.response;

import java.io.Serial;

/**
 * @Desc 错误响应对象
 * @Time 2024-07-12 16:09
 * @Author HuangZhongYao
 */
public class ErrorResponse extends AbstractResponse {

    @Serial
    private static final long serialVersionUID = -8369388190571799068L;

    public ErrorResponse() {
    }

    public ErrorResponse(String msg, String path, Boolean success) {
        super(ResponseCode.FAILED.getCode(), msg, path, success);
    }

    public ErrorResponse(int code,String msg, String path, Boolean success) {
        super(code, msg, path, success);
    }

    @Override
    public void setMessage(String message) {
        super.setMessage(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage() != null ? super.getMessage() : "操作失败";
    }

    @Override
    public Boolean getSuccess() {
        return false;
    }

    /**
     * tostring json格式
     * @return
     */
    @Override
    public String toString() {
        return "{" +
            "  'code' :" + code +
            ", 'message' : '" + message + '\'' +
            ", 'path' : '" + path + '\'' +
            ", 'success' : " + success +
            "}";
    }
}
