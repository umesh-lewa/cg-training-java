package annoshoepack;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBClient {
	public static void main(String[] args)throws Exception {
		ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
		
		DBDemo dbDemo=ctx.getBean("dbDemo",DBDemo.class);
		
		System.out.println(dbDemo.getDataSource().getConnection());
		
		dbDemo.test2();
	}
}

