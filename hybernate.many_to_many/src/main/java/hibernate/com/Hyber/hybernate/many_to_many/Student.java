package hibernate.com.Hyber.hybernate.many_to_many;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

		@Id
		@Column(name="sid")
	String sid;
		@Column(name="sname")
	String sname;
		@ManyToMany
		@JoinTable(name="studentcourse",joinColumns = {@JoinColumn(name="sid")},inverseJoinColumns = {@JoinColumn(name="cid")})
		List<Course> courselist;
		public Student() {
			super();
		}
		public Student(String sid, String sname) {
			super();
			this.sid = sid;
			this.sname = sname;
			courselist=new ArrayList<>();

		}
		public String getSid() {
			return sid;
		}
		public void setSid(String sid) {
			this.sid = sid;
		}
		public String getSname() {
			return sname;
		}
		public void setSname(String sname) {
			this.sname = sname;
		}
		public void addCourse(Course course)
		{
			courselist.add(course);
			course.getStudents().add(this);
		}
		
}
