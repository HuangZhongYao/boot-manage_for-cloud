package org.github.bm.common.validate.impl;

import cn.hutool.core.lang.PatternPool;
import cn.hutool.core.util.StrUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.github.bm.common.validate.ValidateWord;



public class WordValidatorImpl implements ConstraintValidator<ValidateWord, Object> {

    private static final String regexp = "[\\u4e00-\\u9fa5]+";

    boolean required;

    public WordValidatorImpl() {
    }

    @Override
    public void initialize(ValidateWord constraintAnnotation) {
        this.required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        if (!this.required && (null == o || StrUtil.isBlank(o.toString()))) {
            return true;
        }

        if (o instanceof String) {
            // 去掉空格 允许出现空格
            String value = o.toString().replaceAll("\\s", "");
            return PatternPool.WORD.matcher(value).matches();
        }
        return false;
    }
}
