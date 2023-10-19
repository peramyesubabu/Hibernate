package com.kodnest.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController 
{
	Person p;
	@Autowired//connect with person
	public PersonController(Person p) {
		this.p=p;
	}
@GetMapping("/person")
public Person displaypersont() {
	return p;
}
}
