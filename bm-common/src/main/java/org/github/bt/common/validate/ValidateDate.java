package org.github.bt.common.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.github.bt.common.validate.impl.DateValidatorImpl;

import java.lang.annotation.*;

/**
 * 验证时间格式，只能是日期格式。需要指定格式
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
        validatedBy = {DateValidatorImpl.class}
)
public @interface ValidateDate {
    String message() default "日期格式不正确";

    /**
     * 有效的日期格式
     */
    String[] format() default {};


    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
