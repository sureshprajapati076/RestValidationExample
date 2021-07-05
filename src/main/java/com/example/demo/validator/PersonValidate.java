package com.example.demo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = PersonValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PersonValidate {
    String message() default "default some Message";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}