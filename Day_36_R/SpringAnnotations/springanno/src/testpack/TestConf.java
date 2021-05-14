package testpack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Configuration
public class TestConf {
	
	@Bean(name="myBean")
	public MyBean getBean() {
		return new MyBean();
	}
}


class MyBean{
	
	public MyBean() {
		System.out.println("mybean object created...");
	}
}

