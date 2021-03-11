package labbook1;

public class Q23 {

	public static void main(String args[]) {
	
		SubClass1 obj = new SubClass1();
		
		obj.protectedMember = 25;
		
		System.out.println(obj.protectedMember);
	}
}

class SubClass1 {
	
	private int privMember  = 10;
	protected int protectedMember = 10;
	public int publicMember = 10;
	int defaultMember = 10;
	
}
