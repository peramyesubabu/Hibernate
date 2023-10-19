package hibernate.com.Hyber.hybernate.many_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	@Id
	@Column(name="cid")
String cid;
	@Column(name="cname")
String cname;
	@ManyToMany(mappedBy = "courselist")
	List<Student> studlist;
	public Course() {
		super();
	}
	public Course(String cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
		studlist=new ArrayList<>();
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public List<Student> getStudents(){
		return studlist;
	}

}
