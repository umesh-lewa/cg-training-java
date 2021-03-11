package labbook1;

public class Q20 {

	public static void main(String args[]) {
	
		int mat[][]= {
				{1,2,3,4},
				{2,3,4,5},
				{4,5,6,7}
		};
		
		int m = 3;
		int n = 3;
		
		int i = 0, j;
		int max = 0;
		int[] result = new int[m];
		while (i < m){
		for ( j = 0; j < n; j++)
		{
		if (mat[i][j] > max)
		{
		max = mat[i][j];
		}
		}
		result[i] = max;
		max = 0;
		i++;
	
		}
	
		display(result, m);
	
	}
	
	public static void display(int result[], int n){
		
	int i;
	for(i = 0; i < n; i++){
	System.out.print(result[i] + " ");
	}
	
	}
}
