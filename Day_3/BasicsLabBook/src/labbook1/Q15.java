package labbook1;

public class Q15 {

	public static void main(String[] args) {

        int i;
        int num = 0;
        int maxCheck = 100; // maxCheck limit till which you want to find prime numbers
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
    
    
    
}
