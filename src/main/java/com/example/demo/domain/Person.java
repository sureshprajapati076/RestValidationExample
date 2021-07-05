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
    private String changedByDWM_1520;
}