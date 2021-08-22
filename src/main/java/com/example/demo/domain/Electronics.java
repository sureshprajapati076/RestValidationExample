package com.example.demo.domain;

import com.example.demo.validator.ElectronicValidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ElectronicValidate
public class Electronics {
    private String id;
    private String name;
}
