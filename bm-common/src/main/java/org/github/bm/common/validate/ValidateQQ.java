package org.github.bm.common.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.github.bm.common.validate.impl.QQValidatorImpl;

import java.lang.annotation.*;


/**
 * 验证腾讯QQ号
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
        validatedBy = {QQValidatorImpl.class}
)
public @interface ValidateQQ {
    String message() default "QQ号格式错误";

    /**
     * 验证参数是否为必须的
     *
     * @return
     */
    boolean required() default true;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
