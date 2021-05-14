package testpack;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=new AnnotationConfigApplicationContext(TestConf.class);
		
		MyBean mybean=(MyBean)ctx.getBean("myBean");
		
		System.out.println(mybean);
	}
}
