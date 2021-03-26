package day13;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class QuizApp {
	
public static void main(String args[]) {
		
		
		
		Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter No of Questions :");

	    String noOfQuestions = scanner.nextLine(); 

	    
	    Set<Question> questions = new HashSet<Question>();
	    questions.add(new Question("Which is the Capital Of India ?","Chennai","Delhi","Mumbai","Kolkata","Delhi"));
	    questions.add(new Question("Which is the Capital Of the USA ?","Texas","California","Washington DC","Florida","Washington DC"));
	    questions.add(new Question("Which is the Capital Of the UK ?","Greenwich","Essex","Whales","London","London"));
	    
		Set<Question> backupQuestions = new TreeSet<Question>();
		
		boolean flag = true;
		
		while(flag) {
			
			Question currentQuestion = null;
			int totalScore = 0;
			
			int size = questions.size();
			int item = new Random().nextInt(size);
			int i = 0;
			for(Question obj : questions){
				
			    if (i == item) {
			    	currentQuestion = obj;
			    }
			    
			    i++;
			}
			
			System.out.println(currentQuestion.QUESTION);
			System.out.println(currentQuestion.OPTION_A);
			System.out.println(currentQuestion.OPTION_B);
			System.out.println(currentQuestion.OPTION_C);
			System.out.println(currentQuestion.OPTION_D);
			//System.out.println(currentQuestion.CORRECT_OPTION);
			
			String selectedOption = scanner.nextLine();
			
			if(selectedOption.equalsIgnoreCase(currentQuestion.CORRECT_OPTION)) {
				System.out.println("Your answer is correct !");
				totalScore++;
			}else {
				System.out.println("Your answer is wrong");
			}
			
			questions.remove(currentQuestion);
			System.out.println("After Removal....");
			System.out.println(questions.size());
			backupQuestions.add(currentQuestion);
			System.out.println("backupQuestions....");
			System.out.println(backupQuestions.size());
			
			if(questions.size() == 0) {
				System.out.println("Game Over");
				System.out.println("Your total Score is : "+totalScore+"/"+questions.size());
			}else {
				System.out.println("Moving on to the next question");
			}
			
		}
		
	}

}

class Question implements Comparable<Question>{

	String QUESTION;
	String OPTION_A;
	String OPTION_B;
	String OPTION_C;
	String OPTION_D;
	String CORRECT_OPTION;
	
	Question(String QUESTION,String OPTION_A,String OPTION_B,String OPTION_C,String OPTION_D,String CORRECT_OPTION){
		this.QUESTION = QUESTION;
		this.OPTION_A = OPTION_A;
		this.OPTION_B = OPTION_B;
		this.OPTION_C = OPTION_C;
		this.OPTION_D = OPTION_D;
		this.CORRECT_OPTION = CORRECT_OPTION;
	}
	
	@Override
	public int compareTo(Question q) {
		// TODO Auto-generated method stub
		return 1;
	}
	
}
