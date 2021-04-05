import java.sql.*;
import oracle.jdbc.driver.*;
class eg14
{
   public static void main(String str[]) throws Exception
   {
	try
	{
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  	//  Connection con=DriverManager.getConnection("jdbc:odbc:ora","scott","tiger");
 	 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL","scott","tiger");
	//  Statement st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,    ResultSet.CONCUR_READ_ONLY);
	//  Statement st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	  Statement st=con.createStatement();
	  ResultSet rs=st.executeQuery("select * from sam");
	while(rs.next())
	{
	}
 // rs.afterLast();
	  while(rs.previous())
	  {
		String e1=rs.getString(1);
		int e=rs.getInt(2);
		System.out.println("name = " +e1 +"age = " +e);
	   }
	  st.close();
	  con.close();  
	}
	catch(Exception e){e.printStackTrace();}
	
   }
}

