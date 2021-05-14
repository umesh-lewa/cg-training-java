package annoshoepack;

import java.lang.reflect.Field;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessAfterInitialization(Object bean, String name) throws BeansException {
		// TODO Auto-generated method stub
		//logic which is common for all the beans
		System.out.println("After init...:"+name+":"+bean);
		try{
			Field f=bean.getClass().getField("id");
			f.set(bean, 1001);
		}catch(Exception e) {e.printStackTrace();}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("Before init...:"+name+":"+bean);
		return bean;
	}
	
}
