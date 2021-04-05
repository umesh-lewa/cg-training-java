/* Eg., 4 			program for inserting  a record 	*/
import java.sql.*;
class eg4
{
   public static void main(String str[]) throws Exception
   {
	try
	{
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  	  Connection con=DriverManager.getConnection("jdbc:odbc:ora","scott","tiger");
	  Statement st=con.createStatement();
	  st.executeUpdate(" insert into sam values('one1',11)");
	  st.executeUpdate(" insert into sam values('two1',21)");
	  st.executeUpdate(" insert into sam values('three1',31)");
	  st.executeUpdate(" insert into sam values('four1',41)");
	  st.executeUpdate(" insert into sam values('five1',51)");
	  st.close();
	  con.close();
	System.out.println("records successfully  inserted");
	}catch(Exception e){e.printStackTrace();}
     }
}
