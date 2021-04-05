/* selecting rows from emp table */
import java.sql.*;
class eg3
{
   public static void main(String str[]) throws Exception
   {
	try
	{
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  	  Connection con=DriverManager.getConnection("jdbc:odbc:ora","scott","tiger");
	  Statement st=con.createStatement();
	  st.executeUpdate("create table sam(name varchar(15),age int)");
	  st.close();
	  con.close();
	  System.out.println("table created");
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
   }
}
	
