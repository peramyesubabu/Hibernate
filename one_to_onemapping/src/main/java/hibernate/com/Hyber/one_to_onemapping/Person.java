package hibernate.com.Hyber.one_to_onemapping;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="person")
public class Person 
{
	@Id
	@Column(name="Aadhar_id")
String Aadhar_id;
	@Column(name="name")
	String name;
	@Column(name="gender")
	String gender;
	
	@OneToOne(mappedBy = "person",cascade =CascadeType.ALL)
	Aadhar aadhar;
	public void setaadhar(Aadhar aadhar)
	{
		this.aadhar=aadhar;
	}
	public Aadhar getAadhar() {
		return aadhar;
	}
	public Person() {
		super();
	}

	public Person(String aadhar_id, String name, String gender) {
		super();
		this.Aadhar_id= aadhar_id;
		this.name = name;
		this.gender = gender;
	}

	public String getAadhar_id() {
		return Aadhar_id;
	}

	public void setAadhar_id(String aadhar_id) {
		Aadhar_id = aadhar_id;
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
	
}
