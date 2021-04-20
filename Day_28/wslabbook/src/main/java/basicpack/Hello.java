package basicpack;

import javax.jws.WebService;

@WebService
interface Hello{
	
	public Employee sayHello(Employee emp);

}