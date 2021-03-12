package labbook1;

import java.util.Scanner;

public class Q13 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int studentsCount = 5;
		int studentsMarks[][] = new int[studentsCount][3];
		
		for(int i = 0; i < studentsCount; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.println("Enter Mark of Student "+ (i + 1) + " on subject  "+ (j + 1));
				studentsMarks[i][j] = scan.nextInt();
			}
		}
		
		for(int i = 0; i < studentsCount; i++) {
			double avg = getAvg(studentsMarks[i]);
			System.out.println("Student " + (i+1) + " Total : " + (int)(avg * 3) + "  Average : " + avg);
		}
		
	}
	
	static double getAvg(int[] arr) {
		
		int sum = 0;
		
		for(int i : arr) {
			sum += i;
		}
		
		return sum / arr.length;
	}
	
}
