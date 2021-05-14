package codaannopack;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=new AnnotationConfigApplicationContext(TestConfiguration.class);
		
		MyRepoDAO mybean=(MyRepoDAO)ctx.getBean("service");
		
		System.out.println(mybean);
	}
}
