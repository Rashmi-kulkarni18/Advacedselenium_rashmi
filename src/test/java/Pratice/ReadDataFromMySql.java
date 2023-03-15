package Pratice;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import com.mysql.jdbc.Driver;


public class ReadDataFromMySql {

	public static void main(String[] args) throws Throwable  {
		//step 1: Reagister or load the Mysql database
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step 2: Get the connect to database
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/qspiders","root","JoshiRashmi@20");
		
		
		//step 3: create sql statement 
		Statement stat =conn.createStatement();
		
		String selectQuery="select  * from EMP";
		
		
		//STEP 4 Execute statement/query
		ResultSet result =stat.executeQuery(selectQuery);
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
			
		}
		//step 5:close the database coonection
		conn.close();

	}

}
