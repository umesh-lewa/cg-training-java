package query;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import manytomany.Student;
import manytomany.Training;
import utility.HibernateUtility;

public class QueryDemo1 {
	
	public static void main(String[] args) {
		QueryDemo1 obj=new QueryDemo1();
		//obj.query1();
		//obj.query2();
		//obj.query3();
		obj.query4();
	}
	
	public void template() {
		try {
			Session session=HibernateUtility.getSession();
			
			HibernateUtility.closeSession(null);
		}catch(Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
	}
	
	public void query1() {
		try {
			Session session=HibernateUtility.getSession();
			Query query=session.createQuery("from Student");
			List list=query.list();
			Iterator<Student> iter=list.iterator();
			while(iter.hasNext()) {
				Object obj=iter.next();
				System.out.println(obj);
				Student student=(Student)obj;
				System.out.println(student.getSname());
				Set<Training> trainings=student.getTrainings();
				for(Training t:trainings) {
					System.out.println(t.getTname());
				}
			}
			HibernateUtility.closeSession(null);
		}catch(Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
	}
	public void query2() {
		try {
			Session session=HibernateUtility.getSession();
			Query query=session.createQuery("select student.sname from Student student");
			List list=query.list();
			Iterator<String> iter=list.iterator();
			while(iter.hasNext()) {
				Object obj=iter.next();
				System.out.println(obj);
				String name=(String)obj;
				System.out.println("Name...:"+name);
//				Set<Training> trainings=student.getTrainings();
//				for(Training t:trainings) {
//					System.out.println(t.getTname());
//				}
			}
			HibernateUtility.closeSession(null);
		}catch(Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
	}
	public void query3() {
		try {
			Session session=HibernateUtility.getSession();
			Query query=session.createQuery("select student.sname,student.sage from Student student");
			List list=query.list();
			Iterator<Object[]> iter=list.iterator();
			while(iter.hasNext()) {
				Object obj[]=iter.next();
				for(Object o:obj) {
					System.out.println(o);
				}
//				System.out.println("Name...:"+name);
//				Set<Training> trainings=student.getTrainings();
//				for(Training t:trainings) {
//					System.out.println(t.getTname());
//				}
			}
			HibernateUtility.closeSession(null);
		}catch(Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
	}
	public void query4() {
		try {
			Session session=HibernateUtility.getSession();
			Query query=session.createQuery("from Student student where student.sage>30");
			List list=query.list();
			Iterator<Student> iter=list.iterator();
			while(iter.hasNext()) {
				Object obj=iter.next();
				System.out.println(obj);
				Student student=(Student)obj;
				System.out.println(student.getSname());
				Set<Training> trainings=student.getTrainings();
				for(Training t:trainings) {
					System.out.println(t.getTname());
				}
			}
			HibernateUtility.closeSession(null);
		}catch(Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
	}
}
