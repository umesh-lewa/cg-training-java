package exceptionhandling;

public class Q4 {

	public static void main(String args[]) {
		
		try {
			throw new CustomException("Throwing cutsom exception");
		}catch(CustomException ce) {
			ce.printStackTrace();
		}
	}
}
