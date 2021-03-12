package labbook2;

class Wipro{
	
	public void test() {
		System.out.println("Base Method");
	}
	
}

class WiproTechnologies extends Wipro{
	
	public void test() {
		System.out.println("Ovveriden Wipro Technolgies");
	}
	
}

class WiproInfotech extends Wipro{
	
	public void test() {
		System.out.println("Overriden WiproInfotech");
	}
	
}

class WiproBPO extends Wipro{
	
	public void overrideMethod() {
		System.out.println("Overriden WiproBPO");
	}
	
}

public class Q12 {
	
	public static void main(String[] args) {
		Wipro wipro[] = {new WiproTechnologies(), new WiproInfotech(), new WiproBPO()};
		wipro[0].test();
		wipro[1].test();
		wipro[2].test();
	}
}