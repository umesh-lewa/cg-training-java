package labbook1;

public class Q11 {

	public static void main(String args[]) {
		
		int twodarr[][]= {
				{1,0,0,0},
				{2,3,0,0},
				{4,5,6,0},
				{7,8,9,10}
		};
		
		for(int i=0;i<twodarr.length;i++) {
			for(int j=0;j<i;j++) {
				System.out.print(twodarr[i][j]);
			}
			System.out.println("  ");
		}
		
	}
	
}
