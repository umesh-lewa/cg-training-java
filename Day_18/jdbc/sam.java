import java.util.*;
import java.sql.*;
class sam

{
	public static void main(String st1[]) throws Exception
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Enumeration e=DriverManager.getDrivers();
		System.out.println(" " +DriverManager.getLoginTimeout());
		while(e.hasMoreElements())
		{
			System.out.println(e.nextElement());
		}
	}
}
