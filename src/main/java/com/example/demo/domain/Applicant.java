package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;

@Setter
@Getter
public class Applicant {
   private String id;
   @Valid
   private ProfessionalAff professionalAff;
   private boolean tested;
}
