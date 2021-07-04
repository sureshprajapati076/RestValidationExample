package com.example.demo.validator;
import com.example.demo.domain.Person;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;


public class PersonValidator implements ConstraintValidator<PersonValidate, Person> {

    @Override
    public boolean isValid(Person p, ConstraintValidatorContext context) {
        List<String> messages=new ArrayList<>();
        if(p.isPoliticallyExposed()) {

            if (p.getAge() < 18 || p.getAge() > 100) {
                messages.add("Age Must be between 18 - 99");
            }
            if(p.getFirstName()==null || p.getFirstName().length()<=4 || p.getFirstName().length()>=10){
                messages.add("INVALID FIRST NAME");
            }
            if(p.getLastName()==null || p.getLastName().length()<=4 || p.getLastName().length()>=10){
                messages.add("Invalid Last Name");
            }
        }
        if(p.isSeniorExecutive()){
            if(p.getCompanyName()==null || p.getCompanyName().length()<=4 || p.getCompanyName().length()>=10){
               messages.add("Invalid Company Name");
            }
        }
        if(p.isPoliticallyExposed() && p.isSeniorExecutive()){
            messages.add("Can not enable both Flags for this use separate ones");
        }

        if(!messages.isEmpty()) {

            HibernateConstraintValidatorContext hibernateContext =
                    context.unwrap(HibernateConstraintValidatorContext.class);

            hibernateContext.disableDefaultConstraintViolation();
            hibernateContext
                    .buildConstraintViolationWithTemplate(messages.toString())
                    .addConstraintViolation();

            return false;
        }
        return true;
    }

}