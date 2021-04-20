package codaws;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

@HandlerChain(file = "handler.xml")
@WebService(endpointInterface = "codaws.HelloService")
public class HelloServiceImpl implements HelloService{
	
@WebMethod
@Override
public String sayHello(String name) {
	// TODO Auto-generated method stub
	return "Welcome to SOAP based Web Services....:"+name;
}
}
