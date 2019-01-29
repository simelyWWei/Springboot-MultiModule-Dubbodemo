package com.example.demo.validator;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TimeOrderValidator implements ConstraintValidator<TimeOrder, Object> {

    private String startTime;
    private String endTime;
    private String formatPatternStr;
    private DateTimeFormatter formatter;

    @Override
    public void initialize(TimeOrder constraintAnnotation) {
        this.startTime = constraintAnnotation.startTime();
        this.endTime = constraintAnnotation.endTime();
        this.formatPatternStr = constraintAnnotation.formatPattern();
        formatter = DateTimeFormat.forPattern(formatPatternStr);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        //todo:
        if(null == value){
            return true;
        }

        BeanWrapper beanWrapper = new BeanWrapperImpl(value);
        Object startTiemStrValue = beanWrapper.getPropertyValue(startTime);
        Object endTiemStrValue = beanWrapper.getPropertyValue(endTime);

        DateTime startDateTime = DateTime.parse((String) startTiemStrValue, formatter);
        DateTime endDateTime = DateTime.parse((String) endTiemStrValue, formatter);

        if (startDateTime.isBefore(endDateTime)){
            return true;
        }else {
            return false;
        }
    }
}
