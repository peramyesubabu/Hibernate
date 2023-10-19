package hibernate.com.fetching_data;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.hql.internal.ast.tree.RestrictableStatement;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		System.out.println("enter department");
//		String dept = scan.next();
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
		// HIBERNATE QUERY LANGUAGE
//Query query=session.createQuery("from Employee");
//List<Employee> emplist=query.list();
//for ( Employee employee : emplist) {
//	System.out.println(employee);//output:1 ramesh IT
//                                                              //2 suresh Accounts
//                                                              //	3 mahesh Sales
//                                                               //	4 ganesh operations
//}
// 	Query query=session.createQuery("from Employee where department='sales' ");
// 	List<Employee> emplist=query.list();
// for (Employee employee : emplist) {
//	System.out.println(employee);//output:3 mahesh Sales
//}
		// For hcql
		// criteria is a API.. restriction is class provided by criteria API eq means
		// equals this is astatic method present in restriction
//		Criteria criteria = session.createCriteria(Employee.class);
//		criteria.add(Restrictions.eq("department", dept));
//		List<Employee> emplist = criteria.list();
//		for (Employee employee : emplist) {
//			System.out.println(employee);// output:3 mahesh sales
//		}
		Criteria criteria=session.createCriteria(Employee.class);
		//criteria.add(Restrictions.idEq(3));//3 mahesh sales
//		criteria.add(Restrictions.ilike("department","_t%"));//output: 1 ramesh IT
//		criteria.add(Restrictions.ilike("department","%it%"));//output: ramesh IT
//		criteria.add(Restrictions.ilike("department","__"));//output:1 ramesh  IT
		criteria.add(Restrictions.ilike("department","_____"));
		List<Employee> emplist=criteria.list();
		System.out.println(emplist);
		session.getTransaction().commit();
		session.close();
	}
}
