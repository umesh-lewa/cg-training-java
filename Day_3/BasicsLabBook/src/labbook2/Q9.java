package labbook2;

class A{
	
	public int pubMem;
	private int priMem;
	protected int proMem;
	int defaultMem;
	
}
public class Q9 extends A{
	
	public static void main(String args[]) {
		
		
	}
	
	public void getBaseClassMem() {
		
		System.out.println(pubMem);
		//System.out.println(priMem);
		System.out.println(proMem);
		System.out.println(defaultMem);
	}
	
	
}
