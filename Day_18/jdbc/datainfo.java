import java.sql.*;
class datainfo
{
      public static void main(String st[])
      {
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc.odbc.oradsn","scott","tiger");
DatabaseMetaData dbmd=con.getMetaData();
System.out.println("DatabaseProductName     :  "+dbmd.getDatabaseProductName());
System.out.println("DatabaseProductVersion  :"+dbmd.getDatabaseProductVersion());
System.out.println("getStringFunctions            : "+dbmd.getStringFunctions());
System.out.println("DriverMajorVersion          : "+dbmd.getDriverMajorVersion());
System.out.println("DriverMinorVersion          :"+dbmd. getDriverMinorVersion ());
System.out.println("DriverName		    : "+dbmd.getDriverName ());
System.out.println("SQLKeywords 		     : "+dbmd.getSQLKeywords());
con.close();
}catch(Exception e){ e.printStackTrace();}
      } 
}