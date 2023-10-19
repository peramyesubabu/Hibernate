package hibernate.com.hibernate_project_DAO;

import java.util.List;

public interface BankInterface {
public List<Bank> getBank();
public Bank getBankBYAccno(int Accno);
public String persistBank(Bank obj);
public String updateBank(Bank obj);
public String deleteBank(Bank obj);


}
