package hibernate.com.Hyber.hibernate_one_to_many;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@Column(name="id")
String id;
	@Column(name="name")
String name;
	@ManyToOne
	@JoinColumn(name="dept_id")
Department  department;
public Employee() {
	super();
}
public Employee(String id, String name) {
	super();
	this.id = id;
	this.name = name;
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
@Override
public String toString() {
	return  name;
}
public  void setDept(Department dept) {
	this.department=dept;
}
public Department getDept()
{
	return department;
}

}
