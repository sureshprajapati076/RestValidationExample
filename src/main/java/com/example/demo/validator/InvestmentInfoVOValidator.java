package com.example.demo.validator;

import com.example.demo.domain.InvestmentInfoVO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class InvestmentInfoVOValidator implements Validator {
    @Override 	public boolean supports(Class<?> arg0) {
        return InvestmentInfoVO.class.equals(arg0);
    }

    @Override 	public void validate(Object arg0, Errors e) {
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "liquidNetWorth", "liquidNetWorth.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "knowledgeOnEquities", "knowledgeOnEquities.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "knowledgeOnMutualFunds", "knowledgeOnMutualFunds.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "knowledgeOnETFs", "knowledgeOnETFs.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "investmentObjective", "investmentObjective.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "investmentHorizon", "investmentHorizon.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "riskTolerance", "riskTolerance.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "liquidityNeeds", "liquidityNeeds.empty");
    } }
