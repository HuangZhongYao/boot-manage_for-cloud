package org.github.bt.common.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.github.bt.common.validate.impl.URLValidatorImpl;

import java.lang.annotation.*;


/**
 * 验证URL
 *
 * @Desc: Created by IntelliJ IDEA.
 * @Author: ZhongYao.Huang
 * @Copyright: ZuuuuYao By Github
 * @Time: 2024-07-13 15:38
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
    validatedBy = {URLValidatorImpl.class}
)
public @interface ValidateURL {
    String message() default "URL格式错误";

    /**
     * 验证参数是否为必须的
     *
     * @return
     */
    boolean required() default true;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
