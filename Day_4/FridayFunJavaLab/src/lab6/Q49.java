package lab6;

public class Q49 {
	
	public static void main(String args[]) {
		
		Q49 obj = new Q49();
		
		double volume = obj.calcBoxVolume(14, 12, 7);
	}

	public double calcBoxVolume(int l, int b, int h) {
		
		return (l*b*h);
	}
}
