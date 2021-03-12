package labbook2;

class A2{
	
	int a;
	
	A2(int n){
		this.a = n;
	}
	
}

class B2{
	
	int b;
	
	B2(int n){
		this.b = n;
	}
	
}

public class Q11 extends A2{
	
	Q11(int n){
		super(n);
		B2 obj = new B2(n);
	}
	
	public static void main(String[] args) {
		Q11 Obj = new Q11(10);
	}
}
