package annoshoepack;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class ThankyouAdvice implements AfterReturningAdvice{
	
	@Override
	public void afterReturning(Object bean, Method method, Object[] arguments, Object returnedvalue) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Thankyou visit again........");
	}
}
