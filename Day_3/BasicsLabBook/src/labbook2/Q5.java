package labbook2;

public class Q5 {

	static int counter = 0;

	public Q5() {
		counter++;
		System.out.println("Obj Count = " + counter);
	}
	
	public static void main(String[] args) {
		Q5 obj1 = new Q5();
		Q5 obj2 = new Q5();
		Q5 obj3 = new Q5();
	}
	
}
