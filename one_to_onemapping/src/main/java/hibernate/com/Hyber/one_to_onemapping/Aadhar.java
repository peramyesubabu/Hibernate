package hibernate.com.Hyber.one_to_onemapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aadhar")
public class Aadhar {
	@Id
	@Column(name = "id")
String  id;
	@OneToOne
	@JoinColumn(name = "Aadhar_id")
	Person person;

	

	public Aadhar() {
		super();
	}

	public Aadhar(String id,Person person) {
		super();
		this.id=id;
		this.person = person;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
