package labbook2;

class Student {
	
	String name;
	String rollNo;
	
	public Student(String name, String rollNo) {
		this.name = name;
		this.rollNo = rollNo;
	}
	
}


class Exam extends Student{
	
	int sub1Mark;
	int sub2Mark;
	int sub3Mark;
	
	public Exam(String name, String rollNo, int mark1, int mark2, int mark3) {
		super(name, rollNo);
		this.sub1Mark = mark1;
		this.sub2Mark = mark2;
		this.sub3Mark = mark3;
	}
	
}


public class Q14 extends Exam{
	
	int totalMarks;
	
	Q14(String name, String rollNo, int mark1, int mark2, int mark3){
		super(name, rollNo, mark1, mark2, mark3);
	}
	
	public void getTotal(){
		this.totalMarks = this.sub1Mark + this.sub2Mark + this.sub3Mark;
	}
	
	public static void main(String[] args) {
		
		Q14 obj = new Q14("Surya", "1234", 86 , 75, 93);
		obj.getTotal();
		System.out.println(obj.totalMarks);
	}
}
