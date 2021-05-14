package annoshoepack;

import java.util.ArrayList;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdvice implements MethodInterceptor{

	List<Customer> list=new ArrayList<Customer>();
	
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("around advice called...");
		Customer customer=(Customer)mi.getArguments()[0];
		if(list.contains(customer)) {
			throw new ShoeException("Only One Shoe per customer............");
		}
		list.add(customer);
		
		Object obj=mi.proceed();
		return obj;
	}
}
