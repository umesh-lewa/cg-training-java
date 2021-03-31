package day18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo1 {
	
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/EMP";

	   static final String USER = "username";
	   static final String PASS = "password";
	   
	   public static void main(String[] args) {
		   
	   
	   Connection conn = null;
	   Statement stmt = null;
	   
	   try{

	      Class.forName("com.mysql.jdbc.Driver");

	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);


	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT id, first, last, age FROM Employees";
	      ResultSet rs = stmt.executeQuery(sql);



	      rs.close();
	      stmt.close();
	      conn.close();
	      
	   }catch(SQLException se){

	      se.printStackTrace();
	   }catch(Exception e){

	      e.printStackTrace();
	   }finally{

	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }
	      
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }
	   }
	   
	   }

}
