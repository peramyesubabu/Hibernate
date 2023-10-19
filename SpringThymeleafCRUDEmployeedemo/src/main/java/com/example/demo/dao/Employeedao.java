package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Employee;
public interface Employeedao extends JpaRepository<Employee, Integer>{

}
