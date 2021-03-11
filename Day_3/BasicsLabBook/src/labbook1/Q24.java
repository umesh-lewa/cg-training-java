package labbook1;

public class Q24 {

	public static void main(String args[]) {
		
		A obj = new A(1,2,3);
		
		float result = obj.compute(5);
		System.out.println(result);
	}
}

class A{
	
	private int a = 0;
	private int b = 0;
	private int c = 0;
	
	public A() {
		this.a = 1;
		this.b = 1;
		this.c = 1;
		
	}
	
	public A(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
		
	}
	
	public int getA(){
		
		return this.a;
	}
	
	public int getB(){
		
		return this.b;
	}
	
	public int getC(){
		
		return this.c;
	}
	
	public void setABC(int a, int b, int c) {
		
		this.a = a;
		this.b = b;
		this.c = c;
		
	}
	
	public float compute(int x) {
		
		return ((this.a * x * x) + (this.b * x) + this.c);
	}
}
