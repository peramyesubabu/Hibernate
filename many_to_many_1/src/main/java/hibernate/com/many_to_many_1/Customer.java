package hibernate.com.many_to_many_1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//import hibernate.com.Hyber.hybernate.many_to_many.Course;
//import hibernate.com.Hyber.hybernate.many_to_many.Student;

@Enti
@Table(name="customer")
public class Customer {
	@Id
	@Column(name="cust_id")
	String cust_id;
	@Column(name="cust_name")
	String cust_name;
	@ManyToMany
	@JoinTable(name="bankcustomer",joinColumns={@JoinColumn(name="cust_id")},inverseJoinColumns = {@JoinColumn(name="bank_id")})
	List<Bank> banklist;
	public Customer() {
		super();
	}
	public Customer(String cust_id, String cust_name) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		banklist =new ArrayList<>();
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public void addBank(Bank bank)
	{
		banklist.add(bank);
		bank.getCustomer().add(this);
	}
}
