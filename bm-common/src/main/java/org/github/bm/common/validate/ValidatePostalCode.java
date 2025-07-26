package org.github.bm.common.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.github.bm.common.validate.impl.PostalCodeValidatorImpl;

import java.lang.annotation.*;


/**
 * 验证邮政编码
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
        validatedBy = {PostalCodeValidatorImpl.class}
)
public @interface ValidatePostalCode {
    String message() default "邮政编码格式错误";

    /**
     * 验证参数是否为必须的
     *
     * @return
     */
    boolean required() default true;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
