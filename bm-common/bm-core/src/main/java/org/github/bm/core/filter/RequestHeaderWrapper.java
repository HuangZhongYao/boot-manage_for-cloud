package org.github.bm.core.filter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * HttpServletRequest包装器 重写 getHeader
 */
public class RequestHeaderWrapper extends HttpServletRequestWrapper {

    private final Map<String, String> headerMap = new HashMap<>();

    public RequestHeaderWrapper(HttpServletRequest request) {
        super(request);
    }

    public void addHeader(String name, String value) {
        headerMap.put(name, value);
    }

    @Override
    public String getHeader(String name) {
        // 获取自定义头
        String value = this.headerMap.get(name);
        // 优先取自定义头
        if (null != value) {
            return value;
        }
        // 获取原始头
        return super.getHeader(name);
    }

}