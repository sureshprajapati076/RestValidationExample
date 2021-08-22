package com.example.demo.validator;

import com.example.demo.config.Flags;
import com.example.demo.domain.Person;
import lombok.SneakyThrows;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;


public class PersonValidator implements ConstraintValidator<PersonValidate, Person> {

    @Autowired
    private List<String > customerProfile;


    private Flags flags;

    public PersonValidator(Flags flag){
        this.flags=flag;
    }

    @SneakyThrows
    @Override
    public boolean isValid(Person p, ConstraintValidatorContext context) {
        List<String> messages = new ArrayList<>();

        if(flags.isCz4()){
            if(flags.isSuitability()){
                System.out.println("FLAG ON");
            }
        }


        if (p.isPoliticallyExposed()) {
            if (p.getAge() < 18 || p.getAge() > 100) {

                messages.add("Age Must be between 18 - 99");
            }
            if (p.getFirstName() == null || p.getFirstName().length() <= 4 || p.getFirstName().length() >= 10) {
                messages.add("INVALID FIRST NAME");
            }
            if (p.getLastName() == null || p.getLastName().length() <= 4 || p.getLastName().length() >= 10) {
                messages.add("Invalid Last Name");
            }
        }
        if (p.isSeniorExecutive()) {
            if (p.getCompanyName() == null|| !p.getCompanyName().matches("[a-zA-Z]+") || p.getCompanyName().length() <= 4 || p.getCompanyName().length() >= 10 || customerProfile.isEmpty()) {
                messages.add("Company  Name must be between 5 and 10 and must be all letters");
            }
        }
        if (p.isPoliticallyExposed() && p.isSeniorExecutive()) {
            messages.add("Can not enable both Flags for this use separate ones");
        }
        p.setAge(36);

        if (!messages.isEmpty()) {
            HibernateConstraintValidatorContext hibernateContext =context.unwrap(HibernateConstraintValidatorContext.class);
            hibernateContext.disableDefaultConstraintViolation();
            hibernateContext.buildConstraintViolationWithTemplate(messages.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}