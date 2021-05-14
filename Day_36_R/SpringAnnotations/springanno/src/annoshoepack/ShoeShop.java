package annoshoepack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/*
 * <jsp:forward page="a.jsp">
 * 	<jsp:param name="" value=""/>
 * </jsp:forward>
 * 
 */
public abstract class ShoeShop implements Seller {
	public ShoeShop() {
		// TODO Auto-generated constructor stub
	}
	public ShoeShop(ShoeFactory factory) {
		this.factory=factory;
	}
	@Autowired
	@Qualifier("bsf")
	private ShoeFactory factory;

	public ShoeFactory getFactory() {
		return factory;
	}

	public void setFactory(ShoeFactory factory) {
		System.out.println("setter of shoeshop called...");
		this.factory = factory;
	}
	
}
