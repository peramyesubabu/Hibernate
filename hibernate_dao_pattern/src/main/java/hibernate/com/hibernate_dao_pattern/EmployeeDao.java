package hibernate.com.hibernate_dao_pattern;
import java.util.List;
public interface EmployeeDao {
	public List<Employee> getEmployees();
	public Employee getEmployeeById(int id);
	public String persistEmployee(Employee obj);
	public String updateEmployee(Employee obj);
	public String deleteEmployee(Employee obj);
	}


