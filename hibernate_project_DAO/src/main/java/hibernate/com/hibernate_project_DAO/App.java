package hibernate.com.hibernate_project_DAO;

import java.util.List;

public class App {
	public static void main(String[] args) {
//		Bank bank1 = new Bank();
		BankImplementation bank = new BankImplementation();
//		//getting muliple bank accunts objects
		List<Bank> banklist = bank.getBank();
		for (Bank bank2 : banklist) {
			System.out.println(bank2);
		}
		//storing the object
			Bank bank3 = new Bank("suman", "1000", "ss@123", "suman@su", "9701740512");
			String stat = bank.persistBank(bank3);
			System.out.println(stat);
			
			//getting the employee data with id
			Bank b=bank.getBankBYAccno(1);
			System.out.println(b);
			
			//updating the data
			Bank b5=bank.getBankBYAccno(2);
			b5.setAmount("10");
			String status1=bank.updateBank(b5);
			System.out.println(status1);
		//deleting the data from the bank
		Bank b6=bank.getBankBYAccno(1);
		String statu=bank.deleteBank(b6);
		System.out.println(statu);
		}
	}

	
