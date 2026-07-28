package org.github.bm.common.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.github.bm.common.validate.impl.NotNullAndEmptyValidatorImpl;

import java.lang.annotation.*;

/**
 * 验证不能为空或者null
 * @Desc: Created by IntelliJ IDEA.
 * @Author: ZhongYao.Huang
 * @Copyright: ZuuuuYao By Github
 * @Time: 2024-07-13 15:38
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {NotNullAndEmptyValidatorImpl.class}
)
public @interface ValidateNotNullAndEmpty {

    String message() default "不可为Null或空";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
