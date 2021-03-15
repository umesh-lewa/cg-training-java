package lab4;

public class Q40 {
	
	public static void main(String args[]) {
		
		int num = 897;
	    boolean isPrime = false;
	    for (int i = 2; i <= num / 2; ++i) {
	      if (num % i == 0) {
	    	  isPrime = true;
	        break;
	      }
	    }

	    if (!isPrime)
	      System.out.println(num + " is a prime number.");
	    else
	      System.out.println(num + " is not a prime number.");
	    
	}

}
