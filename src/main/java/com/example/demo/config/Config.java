package com.example.demo.config;

import com.example.demo.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Config {

    @Bean("personList")
    public List<Person> getPersonList() {
        return Arrays.asList(
                new Person(),
                new Person()
        );

    }


}
