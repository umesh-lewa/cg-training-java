package hellopack;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

public class AuthenticationClient {
	
	public static void main(String[] args)throws Exception {
		
		QName serviceName=new QName("http://www.haaris.com","myservice");
		
		URL url=new URL("http://localhost/ws/helloService?wsdl");
		
		Service service=Service.create(url, serviceName);
		
		HelloService myservice=service.getPort(HelloService.class);
		
		Map<String, List<String>> headers=new HashMap<>();
		
		headers.put("username", Collections.singletonList("ramu"));
		headers.put("password", Collections.singletonList("spider"));
		
		Map<String,Object> req_ctx=((BindingProvider)myservice).getRequestContext();
		//req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,"http://localhost/ws/helloService?wsdl");
		req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		
		String result=myservice.sayHello("ramu");
		System.out.println("Result...:"+result);
		
	}
	
}
