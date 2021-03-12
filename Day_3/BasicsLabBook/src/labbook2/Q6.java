package labbook2;

public class Q6 {
	
	static {
		System.out.println("Static block");
	}
	
	public Q6() {
		System.out.println("Constuctor ");
	}

	public static void main(String[] args) {
		
		Q6 obj = new Q6();
	}

}
