package hibernate.com.hibernate_project_DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class BankImplementation implements BankInterface {
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
	public List<Bank> getBank() {
		Session session = null;
		try {
			sf = getSessionFactory();
			session = sf.openSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Bank.class);
			List<Bank> banklist = criteria.list();
			return banklist;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Bank getBankBYAccno(int Accno) {
		Session session=null;
		try
		{
			sf=getSessionFactory();
		session=sf.openSession();
		session.beginTransaction();
		Bank bank=(Bank) session.get(Bank.class,Accno);
		return bank;
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
	public String persistBank(Bank obj) {
		Session session = null;
		try {
			sf = getSessionFactory();
			session = sf.openSession();
			session.beginTransaction();
			session.persist(obj);
			session.getTransaction().commit();
		return "object stored successfully";
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
	public String updateBank(Bank obj) {
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
	public String deleteBank(Bank obj) {
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
