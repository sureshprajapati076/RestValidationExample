package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Investment {
    @Valid
    private InvestmentInfoVO investmentInfoVO;
}
