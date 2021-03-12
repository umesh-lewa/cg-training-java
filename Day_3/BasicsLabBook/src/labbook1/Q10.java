package labbook1;

public class Q10 {
	
	public static void main(String args[]) {
	
		int twodarr[][]= {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		
		for(int i=0;i<twodarr.length;i++) {
			for(int j=0;j<twodarr[i].length;j++) {
				System.out.print(twodarr[i][j]);
			}
			System.out.println("  ");
		}
		
	}

}
