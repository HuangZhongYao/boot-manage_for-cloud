package org.github.bt.common.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.github.bt.common.validate.impl.ChineseValidatorImpl;

import java.lang.annotation.*;

/**
 * 验证中文字符,只能出现中文
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
        validatedBy = {ChineseValidatorImpl.class}
)
public @interface ValidateChinese {
    String message() default "只允许为中文";

    /**
     * 验证参数是否为必须的
     *
     * @return
     */
    boolean required() default true;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
