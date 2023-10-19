package hibernate.com.Hyber.hybernate.many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();

		// congigure hibernate.cfg.xml
		configuration.configure("hibernate.cfg.xml");
		// create service registry
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		// build session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Course c1 = new Course("123", "math");
		Course c2 = new Course("456", "science");

		Student s1 = new Student("1100", "ramesh");
		Student s2 = new Student("1200", "suresh");
		s1.addCourse(c1);
		s2.addCourse(c2);
		session.persist(c1);
		session.persist(c2);
		session.persist(s1);
		session.persist(s2);
		session.getTransaction().commit();
		session.close();

	}
}
