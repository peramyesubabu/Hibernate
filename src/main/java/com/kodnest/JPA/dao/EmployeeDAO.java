package com.kodnest.JPA.dao;

import java.util.List;

import com.kodnest.JPA.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll(); 
	public Employee findById(int id);
	public Employee save(Employee theEmployee) ;
	public void delete(int id);
}
