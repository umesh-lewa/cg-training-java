package basicpack;

import javax.xml.ws.Endpoint;

public class HelloPublisher{
	
	public static void main(String[] args) { 
		
		System.out.println("service ready....");
		Endpoint.publish("http://localhost:8888/ws/hello" , new HelloWorld());
 
	} 
}
