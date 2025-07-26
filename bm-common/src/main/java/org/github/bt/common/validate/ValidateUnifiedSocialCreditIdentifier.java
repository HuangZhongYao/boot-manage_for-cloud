package org.github.bt.common.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.github.bt.common.validate.impl.UnifiedSocialCreditIdentifierValidatorImpl;

import java.lang.annotation.*;


/**
 * 验证统一社会信用代码
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
        validatedBy = {UnifiedSocialCreditIdentifierValidatorImpl.class}
)
public @interface ValidateUnifiedSocialCreditIdentifier {
    String message() default "统一社会信用代码格式错误";

    /**
     * 验证参数是否为必须的
     *
     * @return
     */
    boolean required() default true;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
