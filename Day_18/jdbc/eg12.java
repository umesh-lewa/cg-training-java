/* creating a procedure  
create or replace procedure proc(n number)
as
begin
update emp set  empno=emono + n ;
commit;
end;
*/
/*
creating for pointbase
create or replace procedure getName (IN acno character(10)
*/
mysql>delimiter //

mysql>CREATE PROCEDURE simpleproc(OUT param1 INT)
BEGIN
SELECT COUNT(*) INTO param1 FROM emp;
END;
//

mysql>delimiter ;
/*  Eg., 12			  program for procedure 		*/

import  java.sql.*;
import  java.io.*;

public class eg12
{
public static void main(String st1[ ])
{
   try
   {
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection con = DriverManager.getConnection("jdbc:odbc:ora", "scott","tiger");
	System.out.println("enter Increment value  ");
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	String st=br.readLine();
	int p=Integer.parseInt(st);
	CallableStatement cs=con.prepareCall ( "{call proc(?)}" );
	cs.setInt(1,100);
	cs.execute();
	System.out.println("procedure executed ");
	cs.close();
	Statement stm=con.createStatement();
//	ResultSet rs=st.execute("select * from sam");
	ResultSet rs=stm.executeQuery("select * from sam");
	while(rs.next())
	{
		String name=rs.getString(1);
		int eno=rs.getInt(2);
		System.out.println(eno +"\t " + name );
	}
	rs.close();
	stm.close();
	con.close();
    }catch(Exception es) { 	 System.out.println(es) ;	 }
  }
}

