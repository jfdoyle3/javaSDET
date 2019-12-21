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
	   ResultSet sqlResults=state.executeQuery("select * from CustomerInfo where purchasedDate=CURDATE() and Location ='Asia' and purchasedDate=curdate();");
	   System.out.println("Executed the Query");
	   
		/*
		 * Manually select record items 
		 * sqlResults.next(); // set pointer to First Record
		 * sqlResults.getString(1); 
		 * sqlResults.getString(2);
		 * sqlResults.getInt(3);
		 * sqlResults.getString(4);
		 * sqlResults.next(); // set  pointer to Second Record
		 * 
		 */	  
	   while (sqlResults.next())
	  {
		  System.out.println(sqlResults.getString(1));
		  System.out.println(sqlResults.getString(2));
		  System.out.println(sqlResults.getInt(3));
		  System.out.println(sqlResults.getString(4));
	  }
	  conn.close();
	 }

}
