package labbook2;

class A1{
	A1(){
		System.out.println("A constructor");
	}
}

class B1{
	B1(){
		System.out.println("B constructor");
	}
}

public class Q10 extends A1{
	
	public B1 obj = new B1();
	
	public static void main(String[] args) {
		
		Q10 newObj = new Q10();
		
	}
}
