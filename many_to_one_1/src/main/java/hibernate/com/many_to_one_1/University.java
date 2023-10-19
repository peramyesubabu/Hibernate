package hibernate.com.many_to_one_1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="university")
public class University 
{
@Id
@Column(name="univ_id")
String  univ_id;
@Column(name="univ_name")
String univ_name;
@OneToMany(mappedBy="university",cascade = CascadeType.ALL)
List<Student> stdlist;
public University() {
	super();
}
public University(String  univ_id, String univ_name) {
	super();
	this.univ_id = univ_id;
	this.univ_name = univ_name;
stdlist=new ArrayList<>();
}
public String  getUniv_id() {
	return univ_id;
}
public void setUniv_id(String univ_id) {
	this.univ_id = univ_id;
}
public String getUniv_name() {
	return univ_name;
}
public void setUniv_name(String univ_name) {
	this.univ_name = univ_name;
}
public void setStudent(Student student)
{
	student.setUniversity(this);
	stdlist.add(student);
}


}
