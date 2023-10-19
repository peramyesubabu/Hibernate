package hibernate.com.hibernate_project_DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bank")
public class Bank {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY.AUTO)
@Column(name="Accno")
int Accno;
@Column(name="name")
String name;
@Column(name="amount")
String amount;
@Column(name="password")
String password;
@Column(name="email")
String email;
@Column(name="phone")
String phone;
public Bank() {
	super();
}
public Bank(String name, String amount, String password, String email, String phone) {
	super();
	this.name = name;
	this.amount = amount;
	this.password = password;
	this.email = email;
	this.phone = phone;
}
public int getAccno() {
	return Accno;
}
public void setAccno(int accno) {
	Accno = accno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAmount() {
	return amount;
}
public void setAmount(String amount) {
	this.amount = amount;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
@Override
public String toString() {
	return "Bank [Accno=" + Accno + ", name=" + name + ", amount=" + amount + ", password=" + password + ", email="
			+ email + ", phone=" + phone + "]";
}


}
