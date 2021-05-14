package codaannopack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

	@Bean(name = {"service"})
	public MyRepoDAO getService() {
		return new MyRepoDAO();
	}
}
