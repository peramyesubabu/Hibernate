package hibernate.com.Hyber.hibernate_many_to_one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="products")
public class Products {
	@Id
	@Column(name="id")
	String id;

	@Column(name="name")
	String name;

	@ManyToOne
	@JoinColumn(name="categeory_id")
	Categeory category;

	public Products() {
		// TODO Auto-generated constructor stub
	}

	public Products(String id, String name, Categeory category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
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

	public Categeory getCategory() {
		return category;
	}

	public void setCategory(Categeory category) {
		this.category= category;
	}


}
