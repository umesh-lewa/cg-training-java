package exceptionhandling;

public class Q6 {
	
	Q6() throws RuntimeException{
		throw new RuntimeException();
	}

}


class Derived extends Q6{
	
	Derived(){
		super();
	}
}