package org.github.bt.common.validate.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.github.bt.common.validate.ValidateDate;

import java.text.SimpleDateFormat;


public class DateValidatorImpl implements ConstraintValidator<ValidateDate, String> {

    private String[] formats;

    public DateValidatorImpl() {
    }

    @Override
    public void initialize(ValidateDate constraintAnnotation) {
        this.formats = constraintAnnotation.format();

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value==null || "".equals(value.trim())){return true;}

        for (String string : formats) {
            try{
                SimpleDateFormat formatter = new SimpleDateFormat(string);
                formatter.parse(value);
            }catch(Exception e){
                return false;
            }
        }
        return true;

    }
}
