package org.github.bm.common.exception;

import lombok.*;

import java.io.Serial;

/**
 * @Desc: Created by IntelliJ IDEA.
 * @Author: ZhongYao.Huang
 * @Copyright: ZuuuuYao By Github
 * @Time: 2024-07-12 23:17
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BaseException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = -2879418308051820890L;

    private int code;

    public BaseException(int code) {
        this.code = code;
    }

    public BaseException(String message, int code) {
        super(message);
        this.code = code;
    }

    public BaseException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public BaseException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression,
                         boolean writableStackTrace, int code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

}
