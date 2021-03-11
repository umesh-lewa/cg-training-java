package labbook1;

public class Q17 {
	
	public void Q17(int val, String val2) {
		
	}

	static final int a = 10;
	
	public static void main(String args[]) {
		
		// a = 13;
		
		Q17 obj = new Q17();
		obj.nonStaticMethod();
	}
	
	public void nonStaticMethod() {
		System.out.println("Static Member : "+a);
	}
}
