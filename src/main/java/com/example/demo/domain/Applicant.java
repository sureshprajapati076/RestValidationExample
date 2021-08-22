package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@Setter
@Getter
public class Applicant {
    @Size(min=4, max=10, message = "Applicatn id should be between 4 and 10")
    private String id;
    @Valid
    private ProfessionalAff professionalAff;
    private boolean tested;
}
