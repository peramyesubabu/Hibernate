package hibernate.com.many_to_one_1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
@Id
@Column(name="id")
String  id;
@Column(name="name")
String name;
@ManyToOne
@JoinColumn(name="univ_id")
University university;
public Student() {
	// TODO Auto-generated constructor stub
}
public Student(String id, String name) {
	super();
	this.id = id;
	this.name = name;
//	this.student=student;
}
public String getId() {
	return id;
}
public void setId(String  id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public University getUniversity() {
	return university;
}
public void setUniversity(University university) {
	this.university = university;
}


}
