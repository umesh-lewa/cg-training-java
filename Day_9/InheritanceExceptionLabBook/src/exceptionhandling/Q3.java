package exceptionhandling;

public class Q3 {

	public static void main(String p[])
	{
	sample s=new
	sample();
	s.mth1();
	}
}

class sample{ 
	public void mth1(){
		mth2(); 
		System.out.println("caller");
	}
public void mth2(){
	
try{
System.exit(0);
}catch(Exception e){ System.out.println("catch-mth2");}
/*
B-30 Twin Courtz Apartments, Anna High Road, Perungudi, Chennai –600096
GSTIN - 33AJDPM3302R1Z6 – Cell Phone: 9514234319 / 7448576014
*/
finally{System.out.println("finally-mth2");}
}

}