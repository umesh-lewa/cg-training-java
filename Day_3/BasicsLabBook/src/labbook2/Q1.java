package labbook2;

public class Q1 {
		
	public static void main(String[] args) {
		
		int in = 2;
		double dbl = 3.3;
		char chr = 'h';
		int arr[] = {10,11,12};
		
		display(in, dbl, chr, arr);
		passValues(in, dbl, chr, arr);
		display(in, dbl, chr, arr);
	}

	public static void passValues(int in, double dbl, char chr, int[] arr) {
		in = 4;
		dbl = 4.4;
		chr = 'i';
		for(int j = 0; j < arr.length; j++) {
			arr[j]++;
		}
	}
	
	public static void display(int in, double dbl, char chr, int[] arr) {
		System.out.println("int  = " +in);
		System.out.println("double  = " +dbl);
		System.out.println("char  = " + chr);
		System.out.println("arr = ");
		for(int j = 0; j < arr.length; j++) { 
			System.out.println(arr[j]);
		}
	}
	
}
