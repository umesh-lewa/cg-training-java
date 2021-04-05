import java.sql.*;
class ins 
{
	public static void main(String str[]) throws Exception
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:ora","scott","tiger");
		Statement st=con.createStatement();
		DatabaseMetaData db=con.getMetaData();
		System.out.println("database product name    :"+db.getDatabaseProductName());
		System.out.println("database product varsion :"+db.getDatabaseProductVersion());
		System.out.println("driver major vrsion      :"+db.getDriverMajorVersion());
		System.out.println("driver minor version     :"+db.getDriverMinorVersion());
		System.out.println("database string functions:"+db.getStringFunctions());
		System.out.println("driver name              :"+db.getDriverName());
		System.out.println("driver version           :"+db.getDriverVersion());
		con.close();

	}
}
