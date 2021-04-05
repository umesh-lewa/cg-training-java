
/*  Eg. 10		 For PreparedStatement 		*/
import java.sql.*;
class eg10
{
	public static void main(String st[])
{
   try
   {
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection con=DriverManager.getConnection("jdbc:odbc:ora","scott","tiger");
 	PreparedStatement ps=con.prepareStatement("select * from sam where age>= ?");
	ps.setInt(1,20);
	ResultSet rs=ps.executeQuery();
	System.out.println("empno \t\t empname ");
	while(rs.next())
	{
		String e1=rs.getString(1);
		 int e=rs.getInt(2);
		System.out.println("name = " +e1 +"\t age = " +e);
	 }
	  rs.close();
	  ps.close();
	  con.close();
     }catch(Exception e)
       {   e.printStackTrace(); }
}
}
