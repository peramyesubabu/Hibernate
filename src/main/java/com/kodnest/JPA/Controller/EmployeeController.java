package com.kodnest.JPA.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodnest.JPA.entity.Employee;
import com.kodnest.JPA.service.EmployeeDAOService;

@RestController
@RequestMapping("/getapi")
public class EmployeeController {
	EmployeeDAOService eds;

	@Autowired

	public EmployeeController(EmployeeDAOService eds) {

		this.eds = eds;

	}

	@GetMapping("/getallemployees")

	public List<Employee> findAllEmployees()

	{

		return eds.findAll();

	}

	@GetMapping("/getempbyid/{empid}")

	public Employee findEmployeeById(@PathVariable int empid)

	{

		return eds.findById(empid);

	}

	@PostMapping("/saveemp")

	public Employee saveEmployee(@RequestBody Employee emp)

	{

		return eds.save(emp);

	}

	@PutMapping("/updateemp")

	public Employee updateEmployee(@RequestBody Employee emp)

	{

		return eds.update(emp);

	}

	@DeleteMapping("/deleteemp/{empid}")

	public String deleteEmployee(@PathVariable int empid)

	{

		eds.delete(empid);

		return "Delete Success";

	}
}
