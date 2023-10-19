package hibernate.com.hibernate_bank_dao;

import java.util.Scanner;
public class App 
{
    public static void main( String[] args )
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("welcome to the bank");
        Bankimplementationdao bid=new Bankimplementationdao();
        while(true)
        {
        	System.out.println("Enter 1 for REGISTRATION");
        	System.out.println("Enter 2 for LOGIN");
        	System.out.println("Enter 3 for CHANGE PASSWORD");
        	System.out.println("Enter 4 for BALANCE ENQUIRY");
        	System.out.println("Enter 5 for TRANSFER MONEY");
        	System.out.println("Enter 6 for UPDATE PROFILE");
        	System.out.println("Enter 7 for DELETE ACCOUNT");
        	System.out.println("Enter 8 for DETAILS");
        	System.out.println("Enter 9 for stop");
        	System.out.println("Enter your choice");
        int choice=scan.nextInt();
        switch(choice)
        {
        case 1:bid.bankRegister();
        break;
        case 2:bid.bankLogin();
        break;
        case 3:bid.changePassword();
        break;
        case 4:bid.balanceEnquiry();
        break;
        case 5:bid.transferMoney();
        break;
        case 6:bid.updateProfile();
        break;
        case 7:bid.deleteAccount();
        break;
        case 8: bid.getDetails();
        break;
        default:
        	System.out.println("thank you for choosing the bank");
        	System.exit(0);
        }
        }
       
    }
}
