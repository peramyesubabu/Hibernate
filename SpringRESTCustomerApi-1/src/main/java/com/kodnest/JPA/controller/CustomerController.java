package com.kodnest.JPA.controller;

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

import com.kodnest.JPA.entity.Customer;
import com.kodnest.JPA.service.CustomerDAOService;

@RestController

@RequestMapping("/custapi")

public class CustomerController {

	CustomerDAOService cds;

	@Autowired

	public CustomerController(CustomerDAOService cds) {

		this.cds = cds;

	}

	@GetMapping("/getallcustomers")

	public List<Customer> findAllCustomers()

	{

		return cds.findAll();

	}

	@GetMapping("/getcustbyid/{custid}")

	public Customer findCustomerById(@PathVariable int custid)

	{

		return cds.findById(custid);

	}

	@PostMapping("/savecust")

	public Customer saveEmployee(@RequestBody Customer cust)

	{

		return cds.save(cust);

	}

	@PutMapping("/updatecust")

	public Customer updateCustomer(@RequestBody Customer cust)

	{

		return cds.update(cust);

	}

	@DeleteMapping("/deletecust/{custid}")

	public String deleteCustomer(@PathVariable int custid)

	{

		cds.delete(custid);

		return "Delete Success";

	}

}
