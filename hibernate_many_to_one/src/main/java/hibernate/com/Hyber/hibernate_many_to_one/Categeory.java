package hibernate.com.Hyber.hibernate_many_to_one;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Categeory {

	@Id
	@Column(name="id")
	String id;
	
	@Column(name="name")
	String name;
	
	@OneToMany(mappedBy = "category" , cascade = CascadeType.ALL)
List<Products> productlist;
	
	public Categeory() {
		// TODO Auto-generated constructor stub
	}

public Categeory(String id, String name) {
	super();
	this.id = id;
	this.name = name;
	productlist=new ArrayList();
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
	
public void addProduct(Products product)
{
	product.setCategory(this);
	productlist.add(product);
}
	
}

