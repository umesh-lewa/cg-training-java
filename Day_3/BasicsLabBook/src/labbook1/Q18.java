package labbook1;

public class Q18 {
	
	public static void main(String[] args) {

		int number = 125;
		
		String str = String.valueOf(number);
		
		System.out.printf("%s %s %s%n", 
				eachDigitToWord(str.charAt(0)), 
				eachDigitToWord(str.charAt(1)), 
				eachDigitToWord(str.charAt(2)));
		
	}
	
	private static String eachDigitToWord(char ch) {
	    switch(ch) {    
	    case '0': return "Zero";
	    case '1': return "One";
	    case '2': return "Two";
	    case '3': return "Three";
	    case '4': return "Four";
	    case '5': return "Five";
	    case '6': return "Six";
	    case '7': return "Seven";
	    case '8': return "Eight";
	    case '9': return "Nine";
	    }
	    
	    return "Unsupported Character";
	   
	}
	
}
