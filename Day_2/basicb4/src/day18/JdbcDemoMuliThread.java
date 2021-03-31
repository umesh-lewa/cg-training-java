package day18;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

public class JdbcDemoMuliThread{
	
	public static void main(String args[]) throws SQLException {
		
		try (InputStream input = new FileInputStream("jdbc.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("db.url"));
            System.out.println(prop.getProperty("db.user"));
            System.out.println(prop.getProperty("db.pass"));
            
            JdbcDemoMuliThread obj = new JdbcDemoMuliThread(prop.getProperty("db.url").toString(),prop.getProperty("db.user").toString(),prop.getProperty("db.pass").toString());

            Connection conn1 = obj.getConnection();
            System.out.println("conn1 : "+conn1);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		
	}
	
    String connString;    
    String user;
    String pwd;

    static final int INITIAL_CAPACITY = 10;
    
    LinkedList<Connection> pool = new LinkedList<Connection>();
    
    public String getConnString() {
        return connString;
    }
    
    public String getPwd() {
        return pwd;
    }

    public String getUser() {
        return user;
    }

    public JdbcDemoMuliThread(String connString, String user, String pwd) throws SQLException {
    	
        this.connString = connString;
        this.user = user;
        this.pwd = pwd;
      
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
             pool.add(DriverManager.getConnection(connString, user, pwd));
        }
              
    }

    public synchronized Connection getConnection() throws SQLException {
    	
        if (pool.isEmpty()) {
            pool.add(DriverManager.getConnection(connString, user, pwd));
        }
        
        return pool.pop();
    }
  
    public synchronized void returnConnection(Connection connection) {
    	
        pool.push(connection);
        
    } 
    
}