package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;

@Getter
@Setter
public class School {
    @Valid
    private Applicant applicant;
    private UserDetail userDetail;
    private String schoolId;

}
