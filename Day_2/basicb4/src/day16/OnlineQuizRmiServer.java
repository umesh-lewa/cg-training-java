package day16;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class OnlineQuizRmiServer extends UnicastRemoteObject implements Quiz{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6278280474895168087L;
	
	private static Set<Question> questions = new HashSet<Question>();
	
	protected OnlineQuizRmiServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String[] getQuestion() throws RemoteException {
		
		Question currentQuestion = null;
		int size = questions.size();
		int item = new Random().nextInt(size);
		int i = 0;
		
		for(Question obj : questions){
			
		    if (i == item) {
		    	currentQuestion = obj;
		    }
		    
		    i++;
		}
		
		questions.remove(currentQuestion);
		
		String[] q = new String[6];
		q[0] = currentQuestion.QUESTION;
		q[1] = currentQuestion.OPTION_A;
		q[2] = currentQuestion.OPTION_B;
		q[3] = currentQuestion.OPTION_C;
		q[4] = currentQuestion.OPTION_D;
		q[5] = currentQuestion.CORRECT_OPTION;
		
		return q;
	
	}
	
	public static void main(String[] args)throws Exception {
		
		
		questions.add(new Question("Which is the Capital Of India ?","Chennai","Delhi","Mumbai","Kolkata","Delhi"));
		questions.add(new Question("Which is the Capital Of the USA ?","Texas","California","Washington DC","Florida","Washington DC"));
		questions.add(new Question("Which is the Capital Of the UK ?","Greenwich","Essex","Whales","London","London"));
		
		OnlineQuizRmiServer onlineQuizRmiService=new OnlineQuizRmiServer();
		
		LocateRegistry.createRegistry(1099);
		
		System.out.println("Server Ready....");
		
		Naming.bind("rmi://localhost:1099/rmiservice/quizService", onlineQuizRmiService);
			
	}
	
}
