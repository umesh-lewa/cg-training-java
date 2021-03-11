package labbook1;

public class Q5 {

	public static void main(String args[]) {
		
		Q5 obj = new Q5();
		int[] numbers = new int[]{1,2,3,4,5,6,7};
		System.out.println(obj.calcAverage(numbers));
	}
	
	public float calcAverage(int[] numbers) {
		
	       int sum = 0;
	       
	       for(int i=0; i < numbers.length ; i++) {
	        sum = sum + numbers[i];
	       }
	       
	       float average = sum / numbers.length;
	        
	       return average;
	}
	
}
