package Pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataFromMySqlNonSelectQuery {

	public static void main(String[] args) throws Throwable {
		//step 1: Reagister or load the Mysql database
				Driver driverRef=new Driver();
				DriverManager.registerDriver(driverRef);
				
				//step 2: Get the connect to database
				Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/qspiders","root","JoshiRashmi@20");
				
				
				//step 3: create sql statement 
				Statement stat =conn.createStatement();
				String query="insert into EMP(empid,empname,emplname,empage)values(3,'Shreya','joshi',2)";
				
				//step 4: Execute query
				 int result=stat.executeUpdate(query);//primitive datatype content level comparsion
				 									//non-primitive dattype address level comparsion
				 if(result==1) {
					 System.out.println("user is created");
				 }
				 else {
					 System.out.println("user is not created");
				 }
				 
				 //step 5: close connection
				 conn.close();

	}

}
