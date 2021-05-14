package comcom.avnet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FrameworkService {

	private static  AnnotationConfigApplicationContext appContexts = null;
	
	public static Object getService(String serviceID){
		if(appContexts == null){
			appContexts = new AnnotationConfigApplicationContext(FrameworkConfiguration.class);
		} 
		Object service = appContexts.getBean(serviceID);
		return service;
	}
}
