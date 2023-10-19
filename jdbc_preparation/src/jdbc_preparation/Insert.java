package jdbc_preparation;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Types;
import java.sql.CallableStatement;
import java.sql.Connection;
public class Insert {

	public static void main(String[] args) 
{
		Scanner Scan=new Scanner(System.in);
		String path="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@//localhost:1521/xe";
		String password="system";
		String username="system";
		 // Prepare the stored procedure call
		 String callStatement = "{call jan(?,?)}";
try {
		Class.forName(path);
		Connection con=DriverManager.getConnection(url,username,password);
		CallableStatement cl=con.prepareCall(callStatement);
	System.out.println("enter amount");
	// Set the input parameters
	int amount=Scan.nextInt();
		cl.setInt(1, amount);
		System.out.println("enter age");
		int age=Scan.nextInt();
		cl.setInt(2, age);
	    Boolean b=cl.execute();
//	    System.out.println(b);
if(b==false)
{
	System.out.println("updated successfully");
}
else
{
	System.out.println("some error occured");
}
}
catch(Exception e)
{
	e.printStackTrace();
}
}
}