package hibernate.com.Hyber.hibernate_many_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App {
  public static void main(String[] args) {
	  Configuration configuration = new Configuration();
		
		 //congigure hibernate.cfg.xml
	configuration.configure("hibernate.cfg.xml");
	//create service registry
	StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	.applySettings(configuration.getProperties())
	.build();
	//build session factory
	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	
	Session session=sessionFactory.openSession();
	
	session.beginTransaction();
	 Categeory c1=new Categeory("234", "Electronics");
	 Categeory c2=new Categeory("432", "Fashion");
	 Products p1=new Products("1", "Lappy", c1);
	 Products p2=new Products("2", "mobil", c1);
	 Products p3=new Products("3", "T-Shirt", c2);
	 c1.addProduct(p1);
	 c1.addProduct(p2);
	 c2.addProduct(p3);
	 session.persist(c1);
	 session.persist(c2);
	 session.getTransaction().commit();
	 
	 session.close();
  }

}
