package lab4;

public class Q37 {

	public static void main(String args[]) {
		
		int n = 243;
		int sum = 0; 
        
        while (n != 0) { 
            sum = sum + n % 10; 
            n = n/10; 
        } 
        
        System.out.println(sum);
	}
}
