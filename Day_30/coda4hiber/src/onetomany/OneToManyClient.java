package onetomany;

import java.util.HashSet;

import org.hibernate.Session;

import utility.HibernateUtility;

public class OneToManyClient {
	public static void main(String[] args) {
		
		Employee emp=new Employee();		
		emp.setEname("ramu");
		emp.setEsal(10000);
		
		Address add1=new Address();
		add1.setCity("chennai");
		add1.setStreet("mg street");
		add1.setEmp(emp);
		
		Address add2=new Address();
		add2.setCity("banglore");
		add2.setStreet("abc street");
		add2.setEmp(emp);
		
		HashSet<Address> addresses=new HashSet<Address>();
		addresses.add(add1);
		addresses.add(add2);
		
		emp.setAddresses(addresses);
		
		Session session=HibernateUtility.getSession();
		session.save(emp);
		//session.save(add1);
		//session.save(add2);
		
		HibernateUtility.closeSession(null);
	}
	
}
