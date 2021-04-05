/*  Eg., 5 			selecting rows from emp table */
import java.sql.*;
class eg5
{
   public static void main(String str[]) throws Exception
   {
	try
	{
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  	  Connection con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
	  Statement st=con.createStatement();
	  ResultSet rs=st.executeQuery("select * from SAM");
	  while(rs.next())
	  {
		String e1=rs.getString(1);
		int e=rs.getInt(2);
		System.out.println("name = " +e1 +"age = " +e);
	  }
	st.close();
	  con.close();
   
	}catch(Exception e){e.printStackTrace();}
	  }
}
