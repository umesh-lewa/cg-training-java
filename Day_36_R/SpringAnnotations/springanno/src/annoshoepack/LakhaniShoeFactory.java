package annoshoepack;

import org.springframework.stereotype.Component;

@Component("lsf")
public class LakhaniShoeFactory extends ShoeFactory{
	public int id;
	public LakhaniShoeFactory() {
		System.out.println("lakhani shoe factory object created...");
	}
@Override
public Shoe makeShoe() {
	// TODO Auto-generated method stub
	System.out.println("Application id is...:"+id);
	return new SportsShoe();
}
}
