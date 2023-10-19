package hibernate.com.one_to_many_1;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@Column(name = "c_id")
	String c_id;
	@Column(name = "c_name")
	String name;
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	List<Student> stdlist;

	public Course() {
		super();
	}

	public Course(String c_id, String name) {
		super();
		this.c_id = c_id;
		this.name = name;
		stdlist = new ArrayList<>();
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStudent(Student student) {
		// we are giving the student to course object
		student.setCourse(this);
		// we are giving that student object with course id to store that student object
		// in the list
		stdlist.add(student);
	}

}
