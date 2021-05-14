package annoshoepack;

import org.springframework.aop.ThrowsAdvice;

public class ExceptionAdvice implements ThrowsAdvice{
	public void afterThrowing(ShoeException e) {
		System.out.println("Exception raised.....:"+e);
	}
}
