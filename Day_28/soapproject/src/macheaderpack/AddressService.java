package macheaderpack;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface AddressService {
	
	@WebMethod
	public String sayHello(String name);
	
}
