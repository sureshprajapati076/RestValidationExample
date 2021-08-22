package com.example.demo.domain;

import com.example.demo.validator.InvestmentValidated;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@InvestmentValidated
public class InvestmentInfoVO {

    private String liquidNetWorth;

    private String knowledgeOnEquities;

    private String knowledgeOnMutualFunds;

    private String knowledgeOnETFs;

    private String investmentObjective;

    private String investmentHorizon;

    private String riskTolerance;

    private String liquidityNeeds;


    private String totalNetWorth;

    private BigDecimal totalAnnualIncome;
}
