package hibernate.com.hibernate_bank_dao;

import java.util.Scanner;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

public class Bankimplementationdao implements BankInterfaceDao {
	Scanner Scan = new Scanner(System.in);
	SessionFactory sf = null;

	public SessionFactory getSessionFactory() {
		if (sf == null) {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sf = configuration.buildSessionFactory(serviceRegistry);
			return sf;
		}
		return sf;
	}

	@Override
	public void bankRegister() {// working
		Session session = null;
		try {
			sf = getSessionFactory();
			session = sf.openSession();
			session.beginTransaction();
			System.out.println("Enter name");
			String name = Scan.next();
			System.out.println("Enter Amount");
			String amount = Scan.next();
			System.out.println("Enter Email");
			String email = Scan.next();
			System.out.println("Enter password");
			String password = Scan.next();
			System.out.println("Enter Phonenumber");
			String phone = Scan.next();
			Bank bank = new Bank(name, amount, password, email, phone);
			session.persist(bank);
			session.getTransaction().commit();
			System.out.println("Registered Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		} finally {
			session.close();
		}

	}

	@Override
	public void bankLogin() {// working
		Session session = null;
		try {
			sf = getSessionFactory();
			session = sf.openSession();
			session.beginTransaction();
			System.out.println("Enter Accno");
			int Accno = Scan.nextInt();
			System.out.println("Enter password");
			String password = Scan.next();
			Bank bank = new Bank();
			Criteria criteria = session.createCriteria(Bank.class);
			criteria.add(Restrictions.idEq(Accno));
			List<Bank> b = criteria.list();
			criteria.add(Restrictions.eq("password", password));
			List<Bank> s = criteria.list();
			if (!b.isEmpty() && !s.isEmpty()) {
				System.out.println(s);
				System.out.println("Login successful");
//
			} else {
				System.out.println("Enter valid data");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		} finally {
			session.close();
		}
	}

	@Override
	public void changePassword() // working
	{
		Bank bank = new Bank();
		Session session = null;
		try {
			sf = getSessionFactory();
			session = sf.openSession();
			session.beginTransaction();
			System.out.println("enter accno");
			int accno = Scan.nextInt();
			System.out.println("Enter Emailid");
			String Email = Scan.next();
			System.out.println("Enter password");
			String password = Scan.next();
			Criteria criteria = session.createCriteria(Bank.class);
			criteria.add(Restrictions.eq("email", Email));
			List<Bank> s = criteria.list();
			criteria.add(Restrictions.eq("password", password));
			List<Bank> c = criteria.list();
			if (!s.isEmpty() && !c.isEmpty()) {
				System.out.println("enter new password");
				String newpassword = Scan.next();
				Bank obj = (Bank) session.get(Bank.class, accno);
				obj.setPassword(newpassword);
				session.update(obj);
				session.getTransaction().commit();
				System.out.println("updated successfully");
			} else {
				System.out.println("Check The details");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		} finally {
			session.close();
		}
	}

	@Override
	public void balanceEnquiry() {// working
		Session session = null;
		try {
			sf = getSessionFactory();
			session = sf.openSession();
			session.beginTransaction();
			System.out.println("Enter Accno");
			int Accno = Scan.nextInt();
			System.out.println("Enter password");
			String password = Scan.next();
			Criteria criteria = session.createCriteria(Bank.class);
			criteria.add(Restrictions.idEq(Accno));
			List<Bank> b = criteria.list();
			criteria.add(Restrictions.eq("password", password));
			List<Bank> s = criteria.list();
			if (!b.isEmpty() && !s.isEmpty()) {
				Bank bank = b.get(0);
				System.out.println("Your Balance is:" + bank.getAmount());
			} else {
				System.out.println("please check the details");
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		} finally {
			session.close();
		}
	}

	@Override
	public void transferMoney() {
		Session session = null;
		try {
			sf = getSessionFactory();
			session = sf.openSession();
			session.beginTransaction();
			System.out.println("Enter your Accno");
			int Accno = Scan.nextInt();
			System.out.println("Enter password");
			String password = Scan.next();
			Criteria criteria = session.createCriteria(Bank.class);
			criteria.add(Restrictions.idEq(Accno));
			List<Bank> b = criteria.list();
			criteria.add(Restrictions.eq("password", password));
			List<Bank> s = criteria.list();
//			System.out.println("Enter senders Accno");
//			int Acc = Scan.nextInt();
//			Criteria criteria2 = session.createCriteria(Bank.class);
//			criteria.add(Restrictions.idEq(Acc));
//			List<Bank> z = criteria.list();
			if (!b.isEmpty() && !s.isEmpty()) {
				System.out.println("enter amount to transfer");
				String Amount = Scan.next();
				Bank bank = b.get(0);
//				Bank bank1=z.get(0);

				int a = Integer.parseInt(Amount);// Amount
				int n = Integer.parseInt(bank.getAmount());// present balance
//				int send = Integer.parseInt(bank1.getAmount());// present receivers balance
//				System.out.println(send);
				if (n >= a) {
					int res = n - a;
					bank.setAmount(String.valueOf(res));
//					int res1=send+a;
//					bank1.setAmount(String.valueOf(res1));
					session.getTransaction().commit();
				} else {
					System.out.println("InSuffiecient Balance");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("some error occured");
		} finally {
			session.close();
		}
	}

	@Override
	public void updateProfile() {// working
		Session session = null;
		try {
			sf = getSessionFactory();
			session = sf.openSession();
			session.beginTransaction();
			System.out.println("enter accno");
			int accno = Scan.nextInt();
			System.out.println("Enter Emailid");
			String Email = Scan.next();
			System.out.println("Enter password");
			String password = Scan.next();
			Criteria criteria = session.createCriteria(Bank.class);
			criteria.add(Restrictions.eq("email", Email));
			List<Bank> s = criteria.list();
			criteria.add(Restrictions.eq("password", password));
			List<Bank> c = criteria.list();
			if (!s.isEmpty() && !c.isEmpty()) {
				System.out.println("enter new password");
				String newpassword = Scan.next();
				System.out.println("enter new Mobilenumber");
				String mobileno = Scan.next();
				Bank obj = (Bank) session.get(Bank.class, accno);
				obj.setPassword(newpassword);
				obj.setPhone(mobileno);
				session.update(obj);
				session.getTransaction().commit();
				System.out.println("updated successfully");
			} else {
				System.out.println("Check The details");
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteAccount() {// working
		Session session = null;
		try {
			sf = getSessionFactory();
			session = sf.openSession();
			session.beginTransaction();
			System.out.println("enter accno");
			int accno = Scan.nextInt();
			System.out.println("Enter password");
			String password = Scan.next();
			Criteria criteria = session.createCriteria(Bank.class);
			criteria.add(Restrictions.idEq(accno));
			List<Bank> s = criteria.list();
			criteria.add(Restrictions.eq("password", password));
			List<Bank> c = criteria.list();
			System.out.println(c);
			if (!s.isEmpty() && !c.isEmpty()) {
				Bank obj = (Bank) session.get(Bank.class, accno);
				session.delete(obj);
				session.getTransaction().commit();
				System.out.println("Deleted Suucefully");
			} else {
				System.out.println("please check the details");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("some error occured");
		} finally {
			session.close();
		}

	}

	@Override
	public void getDetails() {// working
		Session session = null;
		try {
			sf = getSessionFactory();
			session = sf.openSession();
			session.beginTransaction();
			System.out.println("Enter Accno");
			int Accno = Scan.nextInt();
			System.out.println("Enter password");
			String password = Scan.next();
			Bank bank = new Bank();
			Criteria criteria = session.createCriteria(Bank.class);
			criteria.add(Restrictions.idEq(Accno));
			List<Bank> b = criteria.list();
			criteria.add(Restrictions.eq("password", password));
			List<Bank> s = criteria.list();
			if (!b.isEmpty() && !s.isEmpty()) {
				System.out.println(s);
			} else {
				System.out.println("check the details once");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("some error occured");
		} finally {
			session.close();
		}

	}

}
