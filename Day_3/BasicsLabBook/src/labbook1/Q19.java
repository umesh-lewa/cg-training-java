package labbook1;

public class Q19 {

	public static void main(String args[]) {
	
		int twodarr[][]= {
				{1,2,3,4},
				{2,3,4,5},
				{4,5,6,7}
		};
	
		for (int i = 0; i < twodarr.length; i++) { 
			   
			int M = twodarr.length;
			int N = twodarr[i].length;
			
	        int start = 0; 
	        int end = N - 1; 
	   
	        while (start < end) { 
	   
	            int temp = twodarr[i][start]; 
	            twodarr[i][start] = twodarr[i][end]; 
	            twodarr[i][end] = temp; 

	            start++; 
	            end--; 
	        }
		}
		
		for(int i=0;i<twodarr.length;i++) {
			//System.out.println(twodarr[i]);
			
			for(int j=0;j<twodarr[i].length;j++) {
				System.out.print(twodarr[i][j]);
			}
			System.out.println("  ");
		}
		
	}
}
