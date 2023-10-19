package com.kodnest.JPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
EmployeeRepository ref;
@Autowired
public EmployeeController(EmployeeRepository ref)
{
	this.ref=ref;
}
@PostMapping("/saveemployee")
public Employee saveEmployee(@RequestBody Employee e)
{
	return ref.save(e);
}
}
