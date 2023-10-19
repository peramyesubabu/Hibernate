package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Employee;
import com.example.demo.services.EmployeeService;

@Controller
@RequestMapping("/crud")
public class EmployeeController {

	EmployeeService es;

	@Autowired

	public EmployeeController(EmployeeService es) {

		this.es = es;

	}

	@GetMapping("/getallemployees")

	public String findAllEmployees(Model thModel)

	{
		List<Employee> emplist = es.findAll();
		thModel.addAttribute("list", emplist);
		return "employee";

	}
}