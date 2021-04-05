/*  Eg. ,11		another eg. For PreparedStatement 	*/
import java.sql.*;
class eg11
{
 public static void main(String st[])
 {
   try
   {
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection con=DriverManager.getConnection("jdbc:odbc:ora","scott","tiger");
	int  no=666 ;String name="sammm";
	PreparedStatement ps=con.prepareStatement("insert into sam values ( ? ,? ) ");
	ps.setString(1,name);
	ps.setInt(2,no);
	ps.executeUpdate();
		ps.close();
	con.close();
	System.out.println(" data inserted ");
    }catch(Exception e)
    {   e.printStackTrace(); }
  }
}
