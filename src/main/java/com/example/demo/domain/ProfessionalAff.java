package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Setter
@Getter
public class ProfessionalAff {

    @Valid
    private Person p1;
    @Valid
    private Person p2;
    @Valid
    List<Person> personList;
    @Size(min=4, max=10, message = "proffId invalid")
    private String proffId;

    @Valid
    private InvestmentInfoVO investmentInfoVO;
}
