package org.github.bm.common.base.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;

/**
 * @Desc 接口响应包装类
 * @Time 2024-07-12 16:02
 * @Author HuangZhongYao
 */
public class ApiResponse<Result> extends AbstractResponse {

    @Serial
    private static final long serialVersionUID = 5094140230570937764L;

    /**
     * 响应数据
     */
    @Schema(description = "响应数据")
    private Result result;

    public ApiResponse(Integer code, String msg, String path, Boolean success, Result result) {
        super(code, msg, path, success);
        this.result = result;
    }

    public ApiResponse(Result result) {
        this.result = result;
    }

    public ApiResponse() {

    }

    /**
     * 创建一个表示操作成功的响应对象。
     *
     * @param result   操作成功的结果数据。
     * @param <Result> 结果数据的泛型类型。
     * @return 返回一个包含成功结果的响应对象。
     */
    public static <Result> ApiResponse<Result> ok(Result result) {
        return new ApiResponse<Result>(ResponseCode.OK.getCode(), "操作成功", "", true, result);

    }

    /**
     * 创建一个表示操作成功的响应对象。
     *
     * @param result   操作成功的结果数据。
     * @param msg      响应信息
     * @param <Result> 结果数据的泛型类型。
     * @return 返回一个包含成功结果的响应对象。
     */
    public static <Result> ApiResponse<Result> ok(Result result, String msg) {
        return new ApiResponse<Result>(ResponseCode.OK.getCode(), msg, "", true, result);

    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "{" +
            " 'result' :" + result +
            ", 'code' :" + code +
            ", 'message' : '" + message + '\'' +
            ", 'path' : '" + path + '\'' +
            ", 'success' : " + success +
            "}";
    }
}
