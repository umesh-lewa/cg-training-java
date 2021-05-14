package annoshoepack;

import org.springframework.stereotype.Component;

@Component("bsf")
public class BataShoeFactory extends ShoeFactory{
	public BataShoeFactory() {
		System.out.println("bata shoe factory object created...");
	}
	public int id;
@Override
public Shoe makeShoe() {
	// TODO Auto-generated method stub
	return new LeatherShoe();
}
}
