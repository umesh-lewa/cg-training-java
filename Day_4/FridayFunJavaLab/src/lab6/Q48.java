package lab6;

public class Q48 {
	
	Q48(int n1, int n2){
		
		System.out.println("Sum of 2 numers : "+(n1 + n2));
	}
	
	Q48(int n1, int n2, int n3){
		
		System.out.println("Sum of 3 numbers : "+(n1 + n2 + n3));
	}
	
	Q48(int n1, int n2, int n3, int n4){
		
		System.out.println("Sum of 4 numbers : "+(n1 + n2 + n3 + n4));
	}
	
	public static void main(String[] args) {
		
		Q48 obj1 = new Q48(1,2);
    	Q48 obj2 = new Q48(1,2,3);
    	Q48 obj3 = new Q48(1,2,3,4);

    }

}
