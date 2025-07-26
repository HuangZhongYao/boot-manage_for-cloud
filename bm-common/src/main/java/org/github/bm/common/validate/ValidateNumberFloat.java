package org.github.bm.common.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.github.bm.common.validate.impl.NumberFloatValidatorImpl;

import java.lang.annotation.*;

/**
 * 验证只能是浮点数
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
        validatedBy = {NumberFloatValidatorImpl.class}
)
public @interface ValidateNumberFloat {
    String message() default "只允许为小数 (浮点数)";

    /**
     * 验证参数是否为必须的
     *
     * @return
     */
    boolean required() default true;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
