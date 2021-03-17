package day8;

public class DecoratorDemo {
	public static void main(String[] args) {
		Food thali=new Rice(new Daal(new Chicken(new Rice())));
		System.out.println("Cost of Rice..+Daal..+chicken+rice..:"+thali.cost());
	}
}
//static composition - static composition is achieved through generalization - part whole hierarchy
abstract class Food{
	public abstract int cost();
}
abstract class VegFood extends Food{
	
}
abstract class NonVegFood extends Food{
	
}
//To do static composition we need to use the constructor
class Rice extends VegFood{
	public Rice() {
		// TODO Auto-generated constructor stub
	}
	private Food food;
	public Rice(Food food) {
		this.food=food;
	}
@Override
	public int cost() {
		// TODO Auto-generated method stub
	if(food!=null) {
		return 10+food.cost();
	}
	else {
			return 10;
		}
	}
}
class Daal extends VegFood{
	public Daal() {
		// TODO Auto-generated constructor stub
	}
	private Food food;
	public Daal(Food food) {
		this.food=food;
	}
@Override
	public int cost() {
		// TODO Auto-generated method stub
	if(food!=null) {
		return 5+food.cost();
	}
	else {
			return 5;
		}
	}
}
class Chicken extends NonVegFood{
	public Chicken() {
		// TODO Auto-generated constructor stub
	}
	private Food food;
	public Chicken(Food food) {
		this.food=food;
	}
@Override
	public int cost() {
		// TODO Auto-generated method stub
	if(food!=null) {
		return 20+food.cost();
	}
	else {
			return 20;
		}
	}
}
