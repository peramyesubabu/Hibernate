package hibernate.com.many_to_one_1;

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

		// congigure hibernate.cfg.xml
		configuration.configure("hibernate.cfg.xml");
		// create service registry
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		// build session factory
		SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();
    session.beginTransaction();
    University university=new University("102","krishna");
    Student student=new Student("1","sai");
    Student student1=new Student("2","charan");
    university.setStudent(student);
    university.setStudent(student1);
    session.persist(university);
    session.getTransaction().commit();
    session.close();
    }
    
}
