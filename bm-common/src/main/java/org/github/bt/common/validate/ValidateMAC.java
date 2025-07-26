package org.github.bt.common.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.github.bt.common.validate.impl.MACValidatorImpl;

import java.lang.annotation.*;

/**
 * 验证MAC物理地址,只能是Mac地址
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
        validatedBy = {MACValidatorImpl.class}
)
public @interface ValidateMAC {
    String message() default "MAC物理地址格式错误";

    /**
     * 验证参数是否为必须的
     *
     * @return
     */
    boolean required() default true;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
