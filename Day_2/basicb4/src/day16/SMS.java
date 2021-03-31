package day16;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SMS extends Remote{

	public String sendSMS(String to,String msg) throws RemoteException;
	
}
