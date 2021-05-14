package comcom.avnet;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class FrameworkAspect {
	private static final String CLASS_NAME = FrameworkAspect.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);

	@Before("execution(* annoshoepack.Seller.sellShoe())")
	public void cry() {
		System.out.println("aspect method before called.....");
		String methodName = "sellShoe";
		//logger.entering(CLASS_NAME, methodName);
		logger.info("selling started");
		//logger.exiting(CLASS_NAME, methodName);
	}
}
