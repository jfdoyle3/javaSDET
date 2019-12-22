import java.sql.DriverManager;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.text.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.sql.ResultSet;

public class oneSingleJson {

	public static void main(String[] args) throws JsonMappingException, JsonGenerationException, ClassNotFoundException, SQLException,IOException {
  
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   Connection connctn=null;
	   
	   ArrayList<CustomerDetails> customerList=new ArrayList<CustomerDetails>();
	   JSONArray jsonArr=new JSONArray();
	   
	   // Connect to Database
	   connctn=DriverManager.getConnection("jdbc:mysql://localhost:3306/business", "root", "DBadmin");
	   System.out.println("Connected to Database");
	   
	   //object of statement class will help us to execute queries
	   Statement ask=connctn.createStatement();
	   ResultSet queryResult=ask.executeQuery("select * from CustomerInfo where purchasedDate=CURDATE() and Location ='Asia' and purchasedDate=curdate();");
	   System.out.println("Executed the Query");
	   
 
	   while (queryResult.next()) /* boolean: the while True until it reaches the last record*/
	  {

		   CustomerDetails customer=new CustomerDetails();
		   customer.setCourseName(queryResult.getString(1));
		   customer.setPurchasedDate(queryResult.getString(2));
		   customer.setAmount(queryResult.getInt(3));
		   customer.setLocation(queryResult.getString(4));

		   customerList.add(customer);
	  }
	   for (int index=0; index<customerList.size(); index++)
	   {
		   
		 //Jackson API
	   ObjectMapper customerObj=new ObjectMapper();
	   customerObj.writeValue(new File("C:\\repository\\SDET\\javaSDET\\JsonJava\\customerInfo"+index+".json"), customerList.get(index));
	   
	   // Gson: Create json String from Java Object
	   Gson gson=new Gson();
	   String jsonString=gson.toJson(customerList.get(index));
	   jsonArr.add(jsonString);
	   }
	   
	   System.out.println(customerList.size()+" Files Created");
	   

	   // Json Simple: .put("data",jsonArr) .  "Data" is json header /array name. jsonArray is the data array
	   JSONObject jsonObj=new JSONObject();
	   jsonObj.put("data",jsonArr);
	   
	   // Apache Commons Text
	   String jsonEscRemoved=StringEscapeUtils.unescapeJava(jsonObj.toJSONString());
	   String stringMod1=jsonEscRemoved.replace("\"{","{");
	   String cleanJsonResult=stringMod1.replace("}\"", "}");
	   System.out.println(cleanJsonResult);
	   
	   // Write CustomerData.json file
	   try (FileWriter jsonFile=new FileWriter("C:\\repository\\SDET\\javaSDET\\JsonJava\\CustomerData.json"))
	   {
		   jsonFile.write(cleanJsonResult);
		   
	   }
	   System.out.println("CustomerData.json written");
	   
	  connctn.close();
	   System.out.println("Connection Closed");
	 }

}
