package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll(); 
	public Employee findById(int id);
	public Employee save(Employee theEmployee);
	public Employee update(Employee theEmployee);
	public void delete(int id);
}