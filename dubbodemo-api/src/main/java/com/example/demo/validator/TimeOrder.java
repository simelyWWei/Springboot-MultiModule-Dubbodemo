package com.example.demo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TimeOrderValidator.class)
@Documented
@Repeatable(TimeOrder.List.class)
public @interface TimeOrder {
    String startTime() default "startTime";
    String endTime() default "EndTime";
    String formatPattern() default "yyyyMMddHHmmss";

    String message() default "";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        TimeOrder[] value();
    }

 }
