package labbook2;

class A{
	A(){
		System.out.println("A constructor");
	}
}

class B{
	B(){
		System.out.println("B constructor");
	}
}

public class Q10 extends A{
	
	public B obj = new B();
	
	public static void main(String[] args) {
		
		Q10 newObj = new Q10();
		
	}
}
