package day14;

import java.util.Enumeration;
import java.util.Properties;

public class PropDemo {
	
	public static void main(String args[]) {
		
		Properties prop = new Properties();
		
		Enumeration e = prop.elements();
		
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		
		prop.getProperty("");
	}

}
