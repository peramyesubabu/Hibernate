package com.kodnest.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
@Id
@Column(name="id")
@GeneratedValue(strategy = GenerationType.IDENTITY.AUTO)
int id;
@Column(name="name")
String name;
@Column(name="result")
int result;
@Column(name="password")
String password;
public Student() {
	super();
}
public Student(String name, int result, String password) {
	super();
	this.name = name;
	this.result = result;
	this.password = password;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getResult() {
	return result;
}
public void setResult(int result) {
	this.result = result;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", result=" + result + ", password=" + password + "]";
}

}
