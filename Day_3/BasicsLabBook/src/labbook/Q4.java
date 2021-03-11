package labbook;

public class Q4 {
	
	public static void main(String[] args) {

	    int testNumber = 29;
	    boolean isNumberPrime = false;
	    
	    for (int i = 2; i <= testNumber / 2; ++i) {
	  
	      if (testNumber % i == 0) {
	    	isNumberPrime = true;
	        break;
	      }
	      
	    }

	    if (!isNumberPrime) {
	      System.out.println("It is a prime number.");
	    }else {
	      System.out.println("Iy is not a prime number.");
	    }
	  }

}
