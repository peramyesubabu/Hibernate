package hibernate.com.Hyber.update;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entit
@Table(name="employee")
public class Employee 
{
	@Column(name="id")
	@Id
String id;
	@Column(name="name")
	String name;
	@Column(name="gender")
	String gender;
	@Column(name="age")
	String age;
	public Employee() {
		super();
	}
	public Employee(String id, String name, String gender, String age) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return id+" "+name+" "+age;
	}
	}
