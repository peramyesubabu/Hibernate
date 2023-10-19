package hibernate.com.hibernate_dao_pattern;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    EmployeeDaoimplement daoimplement=new EmployeeDaoimplement();
//    1.getting the employee list
    List<Employee> emplsit=daoimplement.getEmployees();
    for (Employee employee : emplsit) {
		System.out.println(employee);
		//2.getting the one employee data from the database
	Employee e=daoimplement.getEmployeeById(1);
		System.out.println(e);
		//3.persisting the employee object in the database 
Employee employee2=new Employee("Ajamam","Sales");
String status=daoimplement.persistEmployee(employee2);
System.out.println(status);
//4.updating the database
Employee employee3=daoimplement.getEmployeeById(1);
employee3.setDepartment("NONIT");
String status1=daoimplement.updateEmployee(employee3);
System.out.println(status1);
//5.deleting the object from the database
Employee employee5=daoimplement.getEmployeeById(17);
String statu=daoimplement.deleteEmployee(employee5);
System.out.println(statu);
    }
    }
    
}

