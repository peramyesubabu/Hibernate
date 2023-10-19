package hibernate.com.hibernate_dao_pattern;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class EmployeeDaoimplement implements EmployeeDao {
	SessionFactory sf = null;

	public SessionFactory getSessionFactory() {

		if (sf == null) {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sf = configuration.buildSessionFactory(serviceRegistry);

			return sf;
		}
		return sf;
	}

	@Override
	public List<Employee> getEmployees() {
Session session=null;
try
{
	sf=getSessionFactory();
session=sf.openSession();
session.beginTransaction();
Criteria criteria=session.createCriteria(Employee.class);
List<Employee> employee=criteria.list();
return employee;
	}
catch (Exception e) {

e.printStackTrace();
return null;
}
finally {
	session.close();
}
	}

	@Override
	public Employee getEmployeeById(int id) {
		Session session=null;
		try
		{
			sf=getSessionFactory();
		session=sf.openSession();
		session.beginTransaction();
		Employee employee=(Employee) session.get(Employee.class,id);
		return employee;
	}
		catch (Exception e) {
e.printStackTrace();
return null;
		}
		finally
		{
			session.close();
		}
	}

	@Override
	public String persistEmployee(Employee obj) {
		Session session=null;
		try
		{
			sf=getSessionFactory();
		session=sf.openSession();
		session.beginTransaction();
	 session.persist(obj);
	 session.getTransaction().commit();
		return "object stored in db";
	}
		catch (Exception e) {
e.printStackTrace();
return null;
		}
finally
{
	session.close();
}
	}
	@Override
	public String updateEmployee(Employee obj) {
		Session session=null;
		try
		{
			sf=getSessionFactory();
		session=sf.openSession();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
		
		return "updated successufully";
	}
		catch (Exception e) {
e.printStackTrace();
return null;
		}
		finally {
			session.close();
		}
	}

	@Override
	public String deleteEmployee(Employee obj) {
		Session session=null;
		try
		{
			sf=getSessionFactory();
		session=sf.openSession();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
		
		return "delete successufully";
	}
		catch (Exception e) {
e.printStackTrace();
return null;
		}
		finally {
			session.close();
		}
	}

}
