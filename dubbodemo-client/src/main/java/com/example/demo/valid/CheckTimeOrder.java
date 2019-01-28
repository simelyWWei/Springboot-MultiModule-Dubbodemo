package com.example.demo.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckTimeOrderValidator.class)
@Documented
@Repeatable(CheckTimeOrder.List.class)
public @interface CheckTimeOrder {
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
        CheckTimeOrder[] value();
    }

 }
