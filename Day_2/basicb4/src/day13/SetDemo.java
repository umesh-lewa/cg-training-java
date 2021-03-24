package day13;

import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
	
	public static void main(String args[]) {
		
		Set<Student> s = new TreeSet<Student>((o1,o2)->{return o1.compareTo(o2);});
		s.add(new Student(3000));
		s.add(new Student(450));
		s.add(new Student(250));
		
	}

}

class Student implements Comparable<Student>{

	Integer marks;
	
	Student(Integer marks){
		this.marks = marks;
	}
	
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return o.marks.compareTo(marks);
	}
	
	@Override
	public String toString() {
		return ""+this.marks;
	}
	
}
