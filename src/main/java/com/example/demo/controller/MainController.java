package com.example.demo.controller;

import com.example.demo.domain.Person;
import com.example.demo.domain.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MainController {

	@Autowired
	private List<Person> personList;
	
	@GetMapping("/get")
	public List<Person> getPerson() {
		return personList;
	}

	@PostMapping("/get")
	public School getListPerson(@RequestBody @Valid School school){
		return school;
	}
	
	
}
