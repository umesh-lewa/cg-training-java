package lab4;

public class Q32 {
	
	public static void main(String[] args) {

	    int num = 25, i = 2;
	    
	    boolean isPrime = false;
	    while (i <= num / 2) {
	      if (num % i == 0) {
	    	  isPrime = true;
	        break;
	      }
	      ++i;
	    }

	    if (!isPrime) {
	      System.out.println(num + " is a prime number.");
	    }else {
	      System.out.println(num + " is not a prime number.");
	    }
	  }

}
