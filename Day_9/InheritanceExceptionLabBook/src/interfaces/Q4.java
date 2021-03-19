package interfaces;

public class Q4 {

	
}

interface Inter1{
	
	public void met1();
	
	public void met2();	
}

interface Inter2{
	
	public void met3();
	
	public void met4();
	
}

interface Inter3{
	
    public void met5();
	
	public void met6(); 
	
}

interface Inter4 extends Inter1, Inter2, Inter3{
	
	public void newMet();
}

class Cl1 implements Inter4{
	
	@Override
	public void newMet(){
		
	}
}

class Cl2
