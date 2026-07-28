package org.github.bm.common.base.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.github.bm.common.base.response.ApiResponse;
import org.github.bm.common.base.response.ResponseCode;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @Desc Controller基类
 * @Time 2024-07-11 15:01
 * @Author HuangZhongYao
 */
public class BaseController {

    protected HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attributes.getRequest();
    }

    protected HttpServletResponse getResponse() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attributes.getResponse();
    }

    /**
     * 创建一个表示操作成功的响应对象。
     *
     * @param result   操作成功的结果数据。
     * @param <Result> 结果数据的泛型类型。
     * @return 返回一个包含成功结果的响应对象。
     */
    protected <Result> ApiResponse<Result> ok(Result result) {
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
    protected <Result> ApiResponse<Result> ok(Result result, String msg) {
        return new ApiResponse<Result>(ResponseCode.OK.getCode(), msg, "", true, result);

    }

    /**
     * 创建一个表示请求失败的ApiResponse对象
     *
     * @param msg 失败消息描述
     * @return 包含失败信息的ApiResponse对象
     */
    protected ApiResponse<Void> failed(String msg) {
        ApiResponse<Void> apiResponse = new ApiResponse<>();
        apiResponse.setMessage(msg);
        apiResponse.setCode(ResponseCode.REQUEST_FAILED.getCode());
        apiResponse.setSuccess(false);
        return apiResponse;

    }


    /**
     * 创建一个表示请求失败的ApiResponse对象，可自定义错误码
     *
     * @param msg 失败消息描述
     * @param code 自定义错误码
     * @return 包含失败信息和自定义错误码的ApiResponse对象
     */
    protected ApiResponse<Void> failed(String msg, Integer code) {
        ApiResponse<Void> apiResponse = new ApiResponse<>();
        apiResponse.setMessage(msg);
        apiResponse.setCode(code);
        apiResponse.setSuccess(false);
        return apiResponse;
    }

}
