package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
public class ProfessionalAff {
    @Valid @NotNull
    private Person p1;
    @Valid @NotNull
    private Person p2;
    @Valid @NotNull
    List<Person> personList;
    private String proffId;
}
