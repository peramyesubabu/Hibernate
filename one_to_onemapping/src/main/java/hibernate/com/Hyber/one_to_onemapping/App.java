package hibernate.com.Hyber.one_to_onemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
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
 	Person person=new Person("6303604458","sai","male");
 	Aadhar aadhar=new Aadhar("1",person);
 	person.setaadhar(aadhar);
 	session.persist(person);
 	session.getTransaction().commit();
 	session.close();
    }
}
