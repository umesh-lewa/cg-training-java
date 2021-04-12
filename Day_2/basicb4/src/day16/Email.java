package day16;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Email extends Remote{

	public boolean sendEmail(String to,String msg) throws RemoteException;
	
}
