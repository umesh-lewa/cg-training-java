package day16;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Quiz extends Remote{

	public String[] getQuestion() throws RemoteException;
	
}
