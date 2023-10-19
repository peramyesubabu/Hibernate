package com.kodnest.JPA.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.JPA.entity.Customer;

public interface CustomerJPA extends JpaRepository<Customer, Integer>{

}
