package org.github.bt.common.validate.impl;

import cn.hutool.core.util.StrUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.github.bt.common.validate.ValidateNotChinese;

import java.util.regex.Pattern;


public class NotChineseValidatorImpl implements ConstraintValidator<ValidateNotChinese, Object> {

    private static final Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
    boolean required;

    public NotChineseValidatorImpl() {
    }

    @Override
    public void initialize(ValidateNotChinese constraintAnnotation) {
        this.required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (!this.required && (null == o || StrUtil.isBlank(o.toString()))) {
            return true;
        }
        if (o instanceof String) {
            return !pattern.matcher(o.toString()).find();
        }
        return false;
    }
}
