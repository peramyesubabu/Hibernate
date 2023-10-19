package hibernate.com.Hyber.hibernate_one_to_many;

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
		Department department = new Department("20", "Traning");
		Employee employee = new Employee("8989", "Ramesh");
		Employee employee1 = new Employee("2929", "suresh");
		department.addEmployee(employee);
		department.addEmployee(employee1);

		session.persist(department);
		session.getTransaction().commit();
		session.close();
	}
}
