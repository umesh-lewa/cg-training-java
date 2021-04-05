/* Eg., 6			 deleting a record  */
import java.sql.*;
class eg6
{
   public static void main(String str[]) throws Exception
   {
	try
	{
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  	  Connection con=DriverManager.getConnection("jdbc:odbc:ora","scott","tiger");
	  Statement st=con.createStatement();
	  st.executeUpdate("delete from sam where age=51");
	  ResultSet rs=st.executeQuery("select * from sam");
	 System.out.println("empno"+"\t empname");
	  while(rs.next())
	  {
		String e1=rs.getString(1);
		int e=rs.getInt(2);
		System.out.println("name = " +e1 +"\t age = " +e);
	  }
	  st.close();
	  con.close();
	System.out.println("records successfully  deleted");
	}catch(Exception e){e.printStackTrace();}
     }
}
