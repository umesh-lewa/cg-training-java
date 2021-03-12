package labbook2;

public class Q2{
	
	   double real, img;
		
	   Q2(double r, double i){
		this.real = r;
		this.img = i;
	   }
		
	   public static Q2 sum(Q2 c1, Q2 c2)
	   {
		   Q2 temp = new Q2(0, 0);
	       temp.real = c1.real + c2.real;
	       temp.img = c1.img + c2.img;
	       return temp;
	    }
	   
	    public static void main(String args[]) {
	    	Q2 c1 = new Q2(5.5, 4);
	    	Q2 c2 = new Q2(1.2, 3.5);
	    	Q2 temp = sum(c1, c2);
		    System.out.printf("Sum of two complex number is: "+ temp.real+"+i"+ temp.img);
		}
}