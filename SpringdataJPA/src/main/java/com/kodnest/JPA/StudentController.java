package com.kodnest.JPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController 
{
	StudentRepository ref;
	@Autowired
	public StudentController(StudentRepository ref)
	{
		this.ref=ref;
	}
@GetMapping("/store")
public String Storeobject() 
{
	Student student=new Student("sai",90,"sai123");
	ref.save(student);
	return "student stored successfully";
}
}
