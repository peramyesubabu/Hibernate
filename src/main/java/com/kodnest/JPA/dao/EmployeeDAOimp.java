package com.kodnest.JPA.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kodnest.JPA.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOimp implements EmployeeDAO {
	EntityManager em;

	@Autowired

	public EmployeeDAOimp(EntityManager em) {

		this.em = em;

	}

	@Override
	public List<Employee> findAll() {

		TypedQuery<Employee> query = em.createQuery("from Employee", Employee.class);

		List<Employee> emplist = query.getResultList();

		return emplist;

	}

	@Override

	public Employee findById(int id) {

		return em.find(Employee.class, id);

	}

	@Override

	public Employee save(Employee theEmployee) {

		Employee ref = em.merge(theEmployee);

		return ref;

	}

	@Override

	public void delete(int id) {

		Employee ref = em.find(Employee.class, id);

		em.remove(ref);

	}
}
