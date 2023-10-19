package com.example.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;

import jakarta.transaction.Transactional;
@Service
public class EmployeeServiceimple implements EmployeeService{

	EmployeeService edao;

	@Autowired

	public EmployeeServiceimple(EmployeeService edao) {

		this.edao = edao;

	}

	@Override
	@Transactional
	public List<Employee> findAll() {

		return edao.findAll();

	}

	@Override

	@Transactional

	public Employee findById(int id) {

		// TODO Auto-generated method stub

		return edao.findById(id);

	}

	@Override

	@Transactional

	public Employee save(Employee theEmployee) {

		// TODO Auto-generated method stub

		return edao.save(theEmployee);

	}

	@Transactional

	public Employee update(Employee theEmployee) {

		// TODO Auto-generated method stub

		return edao.save(theEmployee);

	}

	@Override

	@Transactional

	public void delete(int id) {

		// TODO Auto-generated method stub

		edao.delete(id);

	}

}


