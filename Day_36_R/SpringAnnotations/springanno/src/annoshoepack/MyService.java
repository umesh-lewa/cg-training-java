package annoshoepack;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class MyService {
	public MyService() {
		System.out.println("service object created....");
	}
}
