package task12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Question2 {

	public static void main(String[] args)
	{
            String db_url = "jdbc:mysql://localhost:3306";
            String user ="root";
            String password = "root";
            
            try {
				Connection connection = DriverManager.getConnection(db_url, user, password);
				if(connection==null)
				{System.out.println("Connection is made");}
				else
				{System.out.println("Connection is not made");}
				
				String createDB=" CREATE DATABASE JDBC_EMPLOYEEMANAGEMENT";
				String use="USE JDBC_EMPLOYEEMANAGEMENT";
				String createTable="CREATE TABLE EMPL_TABLE (empcode INT, empname VARCHAR(15), empage INT, esalary INT)";
				String insert="INSERT INTO EMPL_TABLE(101, 'Jenny', 25, 10000), (102,'Jacky', 30, 20000), (103, 'Joe', 20, 40000), (104, 'John', 40, 80000), (105, 'Shameer', 25, 90000)";
				String select = "SELECT * FROM EMPL_TABLE";
				
				Statement stmt= connection.createStatement();
				
				stmt.execute(createDB);
				stmt.execute(use);
				stmt.execute(createTable);
                stmt.executeUpdate(insert);
                stmt.executeQuery(select);
                ResultSet res = stmt.executeQuery(select);
                while(res.next()) 
                {
                	System.out.println(res.getInt("empcode")+""+res.getString("empname")+""+res.getInt("empage")+""+res.getInt("esalary"));
                	
                }
                
                connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

	}

}
