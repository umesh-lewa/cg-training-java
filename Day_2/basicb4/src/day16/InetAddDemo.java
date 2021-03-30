package day16;

import java.net.Inet6Address;
import java.net.InetAddress;

public class InetAddDemo {
	
	public static void main(String[] args)throws Exception {
		
		InetAddress i6[]=Inet6Address.getAllByName("www.yahoo.com");
		
		for(InetAddress i:i6) {
			System.out.println(i.getHostAddress());
		}
		
		
	}
}
