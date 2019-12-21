import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class jsonToJava {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
	   
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   Connection conn=null;
	   conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/business", "root", "DBadmin");
	   System.out.println("Connected to Database");
	   
	   //object of statement class will help us to execute queries
	   Statement state=conn.createStatement();
	   ResultSet queryResult=state.executeQuery("select * from CustomerInfo where purchasedDate=CURDATE() and Location ='Asia' and purchasedDate=curdate();");
	   System.out.println("Executed the Query");
	   
		/*
		 * Manually select record items 
		 * queryResult.next(); // set pointer to First Record
		 * queryResult.getString(1); 
		 * queryResult.getString(2);
		 * queryResult.getInt(3);
		 * queryResult.getString(4);
		 * queryResult.next(); // set  pointer to Second Record
		 * 
		 */	  
	   while (queryResult.next())
	  {
		  System.out.println(queryResult.getString(1));
		  System.out.println(queryResult.getString(2));
		  System.out.println(queryResult.getInt(3));
		  System.out.println(queryResult.getString(4));
	  }
	  conn.close();
	 }

}
