package hibernate.com.many_to_many_1;

import java.util.ArrayList;
import java.util.List;




@Table(name="bank")
public class Bank {
@Id
@Column(name="bank_id")
String bank_id;
@Column(name="bank_name")
String bank_name;
@ManyToMany(mappedBy = "banklist")
List<Customer> custlist;
public Bank() {
	super();
}
public Bank(String bank_id, String bank_name) {
	super();
	this.bank_id = bank_id;
	this.bank_name = bank_name;
	custlist=new ArrayList<>();
}
public String getBank_id() {
	return bank_id;
}
public void setBank_id(String bank_id) {
	this.bank_id = bank_id;
}
public String getBank_name() {
	return bank_name;
}
public void setBank_name(String bank_name) {
	this.bank_name = bank_name;
}
public List<Customer> getCustomer()
{
return custlist;
}
}
