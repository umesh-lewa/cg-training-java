package annopack.pojopack;

import java.math.BigDecimal;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Client {
	
public static void main(String[] args)throws Exception {
	//SessionFactory fac=new Configuration().configure().buildSessionFactory();
	
	SessionFactory factory = 
		new AnnotationConfiguration().configure("hibernate.anno.cfg.xml").buildSessionFactory();
	
	Session session=factory.openSession();
	Transaction tx=session.beginTransaction();
	
	Employee employee1 = new Employee();
	employee1.setId(200);
	employee1.setName("Han Yenn");
	
	employee1.setJoiningDate(LocalDate.now());
	employee1.setJoiningTime(LocalTime.now());
	employee1.setJoiningDateTime(LocalDateTime.now());
	employee1.setSalary(new BigDecimal(10000));
	employee1.setSsn("a1");
	
	session.save(employee1);	
	
	
	tx.commit();
	

	
	Query query=session.getNamedQuery("myquery");
	
	List<Employee> list=query.list();
	System.out.println(list.size());
	for(Employee e:list) {
		System.out.println(e);
	}
	
	
}
}
