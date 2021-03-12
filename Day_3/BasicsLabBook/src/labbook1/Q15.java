package labbook1;

public class Q15 {

	public static void main(String[] args) {

        int i;
        int num = 0;
        int maxCheck = 100;
        boolean isPrime = true;

        String primeNumbersFound = "";

        for (i = 1; i <= maxCheck; i++) {
            isPrime = checkIfPrime(i);
            if (isPrime) {
                primeNumbersFound = primeNumbersFound + i + " ";
            }
        }
        System.out.println("Prime numbers from 1 to " + maxCheck + " are:");
        System.out.println(primeNumbersFound);
        
        int checkNum = 234;
        
        if(isArmstrong(checkNum)) {
        	System.out.println("Num is armstrong");
        }else if(isPerfect(checkNum)) {
        	System.out.println("Num is perfect");
        }else if(isPalindrome(checkNum)) {
        	System.out.println("Num is palindrome");
        }else {
        	System.out.println("None of these");
        }
    }
	
    public static boolean checkIfPrime(int numberToCheck) {
    	
        int remainder;
        
        for (int i = 2; i <= numberToCheck / 2; i++) {
            remainder = numberToCheck % i;
            if (remainder == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    
    static boolean isArmstrong(int num) {
    	
    	    int c=0,a,temp;  
    	    int n = num;
    	    temp=n;  
    	    while(n>0)  
    	    {  
    	    a=n%10;  
    	    n=n/10;  
    	    c=c+(a*a*a);  
    	    }  
    	    if(temp==c)  {
    	    	System.out.println("armstrong number"); 
    	    	return true;
    	    }else {  
    	        System.out.println("Not armstrong number");
    	        return false;
    	   }  
		
	}
	
	static boolean isPerfect(int num) {
		
		int n = num , sum = 0;
  
        for(int i = 1; i < n; i++){
            if(n % i == 0){
                sum = sum + i;
            }
        }
        
        if(sum == n){
            System.out.println("Given number is Perfect");
            return true;
        }
        else{
            System.out.println("Given number is not Perfect");
            return false;
        }
        
	}
	
	static boolean isPalindrome(int num) {
		
	        int reversedInteger = 0, remainder, originalInteger;

	        originalInteger = num;

	        for( ;num != 0; num /= 10 ){
	            remainder = num % 10;
	            reversedInteger = reversedInteger * 10 + remainder;
	        }

	        if (originalInteger == reversedInteger) {
	            System.out.println(originalInteger + " is a palindrome.");
	            return true;
	        }else {
	            System.out.println(originalInteger + " is not a palindrome.");
	            return false;
	        }
	}
    
    
}
