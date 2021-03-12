package labbook2;

class SingletonTest { 
	
    private static SingletonTest obj = null; 
  
    public int data; 
  
    private SingletonTest() { 
       data = 99; 
    } 
  
    public static SingletonTest getObj()  {
    	
        if (obj == null) {
        	obj = new SingletonTest(); 
        }
  
        return obj; 
    } 
} 
  
public class Q8 { 
	
    public static void main(String args[]) {
    	
    	SingletonTest o1 = SingletonTest.getObj(); 
    	SingletonTest o2 = SingletonTest.getObj(); 

    	System.out.println(o1.data); 
    	
        o2.data = 199;

        System.out.println(o1.data); 
    } 
    
} 