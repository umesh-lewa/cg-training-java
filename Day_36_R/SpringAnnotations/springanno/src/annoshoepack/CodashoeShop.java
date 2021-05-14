package annoshoepack;

import org.springframework.stereotype.Component;

@Component
public class CodashoeShop extends ShoeShop{
	public int id;
	public CodashoeShop() {
		// TODO Auto-generated constructor stub
	}
	public CodashoeShop(ShoeFactory factory) {
		super(factory);
		System.out.println("coda shoe shop created....");
	}
	public void setup() {
		System.out.println("setup method of codashoeshop called...");
	}
	@Override
	public Shoe sellShoe(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("Application id is...:"+id);
		return getFactory().makeShoe();
	}
	@Override
	public void test() {
		System.out.println("test method of coda called...");
	}
	public void destroy() {
		System.out.println("destroy method is called...........");
	}
}
