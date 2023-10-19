package hibernate.com.Hyber.preparation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Column(name="name")
	@Id
String name;
	@Column(name="age")
String age;
	@Column(name="gender")
String gender;
public Employee() {
	// TODO Auto-generated constructor stub
}
public Employee(String name, String age, String gender) {
	super();
	this.name = name;
	this.age = age;
	this.gender = gender;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public  String toString() {
	return name+" "+age+" "+gender;
}
}
