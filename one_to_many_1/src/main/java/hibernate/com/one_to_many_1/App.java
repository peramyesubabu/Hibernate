package hibernate.com.one_to_many_1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

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
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		// build session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Course course = new Course("908", "bsc");
		Student student = new Student("10", "sai");
		Student student2 = new Student("11", "suman");
		course.setStudent(student);
		course.setStudent(student2);
		session.persist(course);
		session.getTransaction().commit();
		session.close();

	}
}
