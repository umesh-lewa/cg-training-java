package hellopack;

import javax.xml.ws.Endpoint;

public class PublishService {
	
	public static void main(String[] args) {
		
		HelloService myservice=new HelloServiceImpl();
				
		Endpoint.publish("http://localhost:8888/ws/helloService", myservice);
		
		System.out.println("HelloService deployed and running...");
		System.out.println("WSDL enpoint URL for the service is...:\nhttp://localhost:8888/ws/helloService?wsdl");
	}
	
}
