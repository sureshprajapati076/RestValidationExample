package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@Getter
@Setter
public class School {
    @Valid
    private Applicant applicant;
    private UserDetail userDetail;
    @Size(min=4, max=10, message = "School I d shold be 4 to 10 only")
    private String schoolId;
}
