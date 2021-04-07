package login;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.util.Properties;

public class DBUtil {
	
	private DBUtil() {
		// TODO Auto-generated constructor stub
	}
	
	private static String url,username,password;
	
	static {
		try {
			
			url="jdbc:mysql://lrwqyh5q0i7hd9or:mwf3vy3d4aljd4st@lyn7gfxo996yjjco.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/beqm0guzzjfj6e07";
			username="lrwqyh5q0i7hd9or";
			password="mwf3vy3d4aljd4st";
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static ThreadLocal<Connection> tlocal=new ThreadLocal<>();
	
	private static Connection con;
	
	synchronized public static Connection getConnection() {
		con=tlocal.get();
		if(con==null) {
			try {
				con=DriverManager.getConnection(url,username,password);
				con.setAutoCommit(false);
				tlocal.set(con);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	synchronized public static void closeConnection() {
		con=tlocal.get();
		if(con!=null) {
			try {

			con.close();
			tlocal.remove();
			}catch(Exception ee) {
				ee.printStackTrace();
			}
		}
	}
	
	synchronized public static void closeConnection(Exception e,Savepoint sp) {
		con=tlocal.get();
		if(con!=null) {
			try {
				if(e==null) {
					con.commit();//manual commit
				}
				else {
					if(sp==null) {
						con.rollback();
					}
					else {
						con.rollback(sp);
						con.commit();
					}
				}
			con.close();
			tlocal.remove();
			}catch(Exception ee) {
				ee.printStackTrace();
			}
		}
	}
	
}

