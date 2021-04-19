package hellopack;

import java.awt.Image;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloService {
	
	@WebMethod
	public String sayHello(String name);
	
	@WebMethod
	public Employee setEmployee(Employee emp);
	
	@WebMethod
	public Image getImage(String name)throws Exception;
	
	@WebMethod
	public void setImage(Image img,String name)throws Exception;

}

