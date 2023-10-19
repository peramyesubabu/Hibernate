package com.kodnest.JPA.service;

import java.util.List;

import com.kodnest.JPA.entity.Customer;

public interface CustomerDAOService {
	public List<Customer> findAll();

	public Customer findById(int id);

	public Customer save(Customer theCustomer);

	public Customer update(Customer theCustomer);

	public void delete(int id);
}
