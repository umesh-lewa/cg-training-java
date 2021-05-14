package annoshoepack;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class WelcomeAdvice implements MethodBeforeAdvice{
@Override
public void before(Method method, Object[] arguments, Object bean) throws Throwable {
	System.out.println("Welcome Advice Called....");
	Customer customer=(Customer)arguments[0];
	System.out.println("Welcomet to our shoe shop...:"+customer.getName());
}
}
