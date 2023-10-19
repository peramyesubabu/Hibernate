package hibernate.com.Hyber.preparation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
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
Employee employee =new Employee();
Configuration configuration=new Configuration();
configuration.configure("hibernate.cfg.xml");
StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder()
.applySettings(configuration.getProperties())
.build();
SessionFactory sessionfactory=configuration.buildSessionFactory(serviceRegistry);
Session session=sessionfactory.openSession();
session.beginTransaction();
String name="suman";
Employee obj=(Employee) session.get(Employee.class, name);
obj.setAge("20");
session.update(obj);
session.getTransaction().commit();
session.close();
    }
}
