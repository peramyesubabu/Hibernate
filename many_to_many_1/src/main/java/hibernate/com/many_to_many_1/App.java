package hibernate.com.many_to_many_1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
	Configuration configuration= new Configuration();

    	
    	//congigure hibernate.cfg.xml
    	configuration.configure("hibernate.cfg.xml");
    	//create service registry
    	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
    	.applySettings(configuration.getProperties())
    	.build();
    	//build session factory
    	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	Session session=sessionFactory.openSession();
    	session.beginTransaction();
    	Bank b1=new Bank("111","SBI");
    	Bank b2=new Bank("222","INDIAN");
    	Customer c1=new Customer("1021","sai");
    	Customer c2=new Customer("1022","hari");
    	c1.addBank(b1);
    	c2.addBank(b2);
    	session.persist(b1);
    	session.persist(b2);
    	session.persist(c1);
    	session.persist(c2);
    	session.getTransaction().commit();
    	session.close();
    	
    }
}
