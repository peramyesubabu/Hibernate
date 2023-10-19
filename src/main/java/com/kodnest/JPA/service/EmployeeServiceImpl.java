package com.kodnest.JPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.JPA.dao.EmployeeDAO;
import com.kodnest.JPA.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeDAOService {
	EmployeeDAO edao;

	@Autowired

	public EmployeeServiceImpl(EmployeeDAO edao) {

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
