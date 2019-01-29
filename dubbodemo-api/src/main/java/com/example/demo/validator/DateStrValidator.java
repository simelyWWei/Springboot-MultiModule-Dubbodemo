package com.example.demo.validator;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateStrValidator implements ConstraintValidator<DateStr,Object> {
    private String value;
    DateTimeFormatter formatter;

    @Override
    public void initialize(DateStr constraintAnnotation) {
        this.value = constraintAnnotation.formatPattern();
        formatter = DateTimeFormat.forPattern(value);
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        String dateStrIn = (String) o;
        //判断字符串位数是否一致
        if(dateStrIn.length() != value.length()){
            return false;
        }
        try {
            DateTime.parse((String) o, formatter);
        }catch (Exception e) {
            return false;
        }
        return true;
    }
}
