package com.example.demo.domain;

import com.example.demo.validator.PersonValidate;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@PersonValidate
public class Person {

    private String firstName;

    private String lastName;


    private int age;
    @JsonAlias("isPoliticallyExposed")
    private boolean isPoliticallyExposed;
    @JsonAlias("isSeniorExecutive")
    private boolean isSeniorExecutive;

    private String companyName;

}