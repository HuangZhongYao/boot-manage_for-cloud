package org.github.bt.common.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.github.bt.common.validate.impl.NumberIntegerValidatorImpl;

import java.lang.annotation.*;


/**
 * 验证只能是整形
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
        validatedBy = {NumberIntegerValidatorImpl.class}
)
public @interface ValidateNumberInteger {
    String message() default "只允许为整数";

    /**
     * 验证参数是否为必须的
     *
     * @return
     */
    boolean required() default true;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
