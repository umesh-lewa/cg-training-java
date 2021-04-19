package macheaderpack;

import javax.xml.ws.Endpoint;

public class DeployService {
	
	public static void main(String[] args) {
		
		AddressService as=new AddressServiceImpl();
		
		Endpoint.publish("http://localhost:3030/ws/addressService", as);
		
		System.out.println("Service Ready and available at this URL - http://localhost:3030/ws/addressService?wsdl");
		
	}
	
}
