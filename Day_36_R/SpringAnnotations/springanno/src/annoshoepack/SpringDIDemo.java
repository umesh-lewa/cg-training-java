package annoshoepack;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDIDemo {
	public static void main(String[] args) {
		try {
		ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("annoconfig.xml");
		
		Seller seller=ctx.getBean("codashoeShop",Seller.class);
				
		Customer customer=new Customer();
		customer.setName("ramu");
		Shoe shoe=seller.sellShoe(customer);
		//seller.sellShoe(customer);
		//seller.test();
		System.out.println(shoe);
		
		ctx.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	} 
	
}
/*@component,@service,@repository
 *@autowired 
 *@qualifier
 * @Configuration
 * @Service
 * @Repository
 * @Bean 
 * 
*/