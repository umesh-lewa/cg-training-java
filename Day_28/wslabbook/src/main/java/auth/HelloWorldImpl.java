package auth;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext; 
import javax.xml.ws.handler.MessageContext;

//Service Implementation Bean
@WebService(endpointInterface = "auth.HelloWorld")
public class HelloWorldImpl implements HelloWorld{
	
	@Resource
    WebServiceContext wsctx;
    
    @Override
	public String getHelloWorldAsString() {
    	
    	MessageContext mctx = wsctx.getMessageContext();
    	
		//get detail from request headers
		Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
		List userList = (List)
		http_headers.get("Username");
		List passList = (List)
		http_headers.get("Password");
		       
		String username = "";
		String password = "";
	        
		if(userList!=null){
			//get username
			username = userList.get(0).toString();
		}
		
		if(passList!=null){
			//get password
			password = passList.get(0).toString();
		}
		
		//database Should validate username and password with
		if (username.equals("ramu") && password.equals("secret")){
		
			return "Hello World JAX-WS - Valid User!";
		       
		}else{
		
			return "Unknown User!";
		} 
	
	}
    
}

