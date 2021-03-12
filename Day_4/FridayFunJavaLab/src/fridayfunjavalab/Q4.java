package fridayfunjavalab;

public class Q4 {

	public static void main(String args[]) {
		
		int counter = 0 ;
		for(int i = 0 ; i < 4 ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				for(int k = 0 ; k < 4 ; k++) {
					if(i != j && j != k && k != i) {
						System.out.println("Unique 3 digit num found : "+i+j+k);
						counter++;
					}
				}
			}
		}
		
		System.out.println("Total no of unique 3 digit numbers : "+counter);
	}
}
