package com.example.demo.validator;

import com.example.demo.domain.Electronics;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ElectronicValidator implements ConstraintValidator<ElectronicValidate, Electronics> {
    List<String> error;
    @Override
    public void initialize(ElectronicValidate constraintAnnotation) {
        error=new ArrayList<>();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Electronics value, ConstraintValidatorContext context) {
        error.add("SOME ERROR");
        if (!error.isEmpty()) {
            HibernateConstraintValidatorContext hibernateContext =context.unwrap(HibernateConstraintValidatorContext.class);
            hibernateContext.disableDefaultConstraintViolation();
            hibernateContext.buildConstraintViolationWithTemplate(error.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}
