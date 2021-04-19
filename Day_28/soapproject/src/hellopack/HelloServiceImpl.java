package hellopack;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.MTOM;

@MTOM //this annotation is given when we have attachments like image or file
@HandlerChain(file = "handler.xml")
@WebService(endpointInterface = "hellopack.HelloService", targetNamespace = "http://www.haaris.com",serviceName = "myservice")
public class HelloServiceImpl implements HelloService{
	
	@Resource
	WebServiceContext wctx;
	
	@WebMethod
	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		MessageContext mctx=wctx.getMessageContext();
		Map http_headers=(Map)mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
		List names=(List)http_headers.get("username");
		List pwd=(List)http_headers.get("password");
		
		String username="";String password="";
		
		if(names!=null) {
			username=names.get(0).toString();
		}
		
		if(pwd!=null) {
			password=pwd.get(0).toString();
		}
		
		if(username.equals("ramu") && password.equals("spider")) {
			return "Welcome to webservices....."+name;
		}
		else {
			return "You are not authentic...............";
		}		
	}
	
	@WebMethod
	@Override
	public Employee setEmployee(Employee emp) {
		// TODO Auto-generated method stub
		emp.setEname("changed and modified ramu...");
		emp.setEpass("now its spider man");
		System.out.println(emp);
		
		return emp;
	}
	
	@WebMethod
	@Override
	public Image getImage(String name) throws Exception {
		File file=new File(name);
		
		return ImageIO.read(file);
	}
	
	@WebMethod
	@Override
	public void setImage(Image img, String name) throws Exception {
		File file=new File(name);
		BufferedImage bimg=(BufferedImage)img;
		ImageIO.write(bimg, "jpg", file);
	}
	
}
