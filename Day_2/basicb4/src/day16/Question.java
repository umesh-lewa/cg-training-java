package day16;

import java.io.Serializable;

class Question implements Comparable<Question>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1401452782608303570L;
	
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
