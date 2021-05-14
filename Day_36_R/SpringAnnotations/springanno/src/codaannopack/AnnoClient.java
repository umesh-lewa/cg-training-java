package codaannopack;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnoClient {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("codaanoo.xml");
		
		AnnoTest atest=ctx.getBean("annoTest",AnnoTest.class);
		
		System.out.println(atest);
		
		atest.doBusiness();
	}
	
}
