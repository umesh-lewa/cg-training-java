package macheaderpack;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

public class AddressClient {
	
	public static void main(String[] args)throws Exception {
		
		URL url=new URL("http://localhost:3030/ws/addressService?wsdl");
		QName qname=new QName("http://macheaderpack/", "AddressServiceImplService");
		Service service=Service.create(url,qname);
		
		AddressService ss=service.getPort(AddressService.class);
		
		String result=ss.sayHello("ramu");
		System.out.println("Result...:"+result);
		
	}
	
}
