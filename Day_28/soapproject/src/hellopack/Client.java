package hellopack;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client {
	
	public static void main(String[] args)throws Exception {
		
		QName serviceName=new QName("http://www.haaris.com","myservice");
		
		URL url=new URL("http://localhost/ws/helloService?wsdl");
		
		Service service=Service.create(url, serviceName);
		
		HelloService myservice=service.getPort(HelloService.class);
		
		String result=myservice.sayHello("CODA");
		
		System.out.println("Result..:"+result);
		
		Employee emp=new Employee(100,"ramu","spider");
		myservice.setEmployee(emp);
		System.out.println(emp);
					
	}
		
}
