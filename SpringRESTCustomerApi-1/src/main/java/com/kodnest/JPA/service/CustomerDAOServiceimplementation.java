package com.kodnest.JPA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.JPA.dao.CustomerJPA;
import com.kodnest.JPA.entity.Customer;
@Service
public class CustomerDAOServiceimplementation implements CustomerDAOService {

	CustomerJPA ref;

	@Autowired

	public CustomerDAOServiceimplementation(CustomerJPA ref) {

		this.ref = ref;

	}

	@Override

	public List<Customer> findAll() {

		return ref.findAll();

	}

	@Override

	public Customer findById(int id) {

		// TODO Auto-generated method stub

		Optional<Customer> op = ref.findById(id);

		Customer e = op.get();

		return e;

	}

	@Override

	public Customer save(Customer Customer) {

		// TODO Auto-generated method stub

		return ref.save(Customer);

	}

	public Customer update(Customer theCustomer) {

		// TODO Auto-generated method stub

		return ref.save(theCustomer);

	}

	@Override

	public void delete(int id) {

		// TODO Auto-generated method stub

		ref.deleteById(id);

	}

}
