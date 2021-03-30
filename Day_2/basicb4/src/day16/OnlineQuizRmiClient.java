package day16;

import java.rmi.Naming;
import java.util.Scanner;
import java.util.Timer;

public class OnlineQuizRmiClient {

	public static void main(String[] args) throws Exception{
		
		Quiz quiz=(Quiz)Naming.lookup("rmi://localhost:1099/rmiservice/quizService");
		
		int noOfQuestions = 3;
		int qNo = 1;
		
		while(qNo <= noOfQuestions) {
			
			String[] currentQuestion=quiz.getQuestion();
			
			System.out.println(currentQuestion[0]);
			System.out.println(currentQuestion[1]);
			System.out.println(currentQuestion[2]);
			System.out.println(currentQuestion[3]);
			System.out.println(currentQuestion[4]);
			//System.out.println(currentQuestion.CORRECT_OPTION);
			
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			
			int totalScore = 0;
			
		    boolean timeUpFlag = false;
		    
			int i = 10;
			
			String selectedOption = null;
			
			while (i>0){
				
				System.out.println("Remaining: "+i+" seconds");
			    /*
			    try {
			      i--;
			      Thread.sleep(1000L);    // 1000L = 1000ms = 1 second
			     }
			     catch (InterruptedException e) {
			         //I don't think you need to do anything for your particular problem
			     }*/
			  
				 Thread.sleep(1000L);
				
				 selectedOption = scanner.nextLine();
				
			     if(i==1) {
			    	 
				   System.out.println("Time Up...!");

				   timeUpFlag = true;
				  
				   if(qNo == noOfQuestions) {
					   
						System.out.println("Game Over");
						System.out.println("Your total Score is : "+totalScore+"/"+noOfQuestions);
						break;
						
					}else {
						
						System.out.println("Moving on to the next question");
						continue;
						
					}
				   
			  	}else if(selectedOption != null){
			  		break;
			  	}
			  
			  i--;
			  
			 }
			 
			 if(timeUpFlag) {
				 continue;
			 }else {
				 
			 }
	        
	    
						
			if(selectedOption.equalsIgnoreCase(currentQuestion[5])) {
				System.out.println("Your answer is correct !");
				totalScore++;
			}else {
				System.out.println("Your answer is wrong");
			}
			
			
			if(qNo == noOfQuestions) {
				System.out.println("Game Over");
				System.out.println("Your total Score is : "+totalScore+"/"+noOfQuestions);
				break;
			}else {
				System.out.println("Moving on to the next question");
			}
			
			qNo++;
		}
			
	}

}
