package com.example.demo.validator;

import com.example.demo.config.Flags;
import com.example.demo.domain.InvestmentInfoVO;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class InvestmentValidator implements ConstraintValidator<InvestmentValidated, InvestmentInfoVO> {
    private Flags flags;

    public InvestmentValidator(Flags flag){
        this.flags=flag;
    }

    @Override
    public boolean isValid(InvestmentInfoVO value, ConstraintValidatorContext context) {
        List<String> messages = new ArrayList<>();

        if(!(flags.isCz4()  && flags.isSuitability())){
            if(isNullOrEmpty(value.getLiquidityNeeds())){
                messages.add("LN should not be empty or null");
            }
            if(isNullOrEmpty(value.getInvestmentHorizon())){
                messages.add("TH should not be empty or null");
            }
        }
        if(!(flags.isCz4() && flags.isDomiant())){
            if(isNullOrEmpty(value.getLiquidNetWorth())){
                messages.add("ETN should not be empty or null");
            }
        }
        if(!(flags.isCz4() && flags.isRisk())){
            if(isNullOrEmpty(value.getRiskTolerance())){
                messages.add("Risk should not be empty or null");
            }
            if(isNullOrEmpty(value.getInvestmentObjective())){
                messages.add("IO should not be empty or null");
            }
        }

        if (!messages.isEmpty()) {
            HibernateConstraintValidatorContext hibernateContext =context.unwrap(HibernateConstraintValidatorContext.class);
            hibernateContext.disableDefaultConstraintViolation();
            hibernateContext.buildConstraintViolationWithTemplate(messages.toString()).addConstraintViolation();
            return false;
        }



        return true;
    }
    private boolean isNullOrEmpty(String value){
        return value==null || value.isEmpty();
    }
}
