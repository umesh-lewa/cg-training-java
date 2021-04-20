package onetomany;

import java.util.Set;

import org.hibernate.Session;

import utility.HibernateUtility;

public class ReadClient {
	public static void main(String[] args) {
		Session session=HibernateUtility.getSession();
		
		Employee emp=(Employee)session.get(Employee.class, Integer.valueOf(1));
		
		System.out.println(emp.getEname());
		
		Set<Address> addresses=emp.getAddresses();
		
//		for(Address a:addresses) {
//			System.out.println(a.getEmp().getEname());
//		}
	}
}
