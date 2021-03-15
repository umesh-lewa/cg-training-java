package lab6;

public class Q47 {
	
	
    public static void main(String[] args) {    
    	Q47 obj = new Q47();

        System.out.println("Sum of two numbers: "+obj.addOperation(10, 20));
        System.out.println("Sum of three numbers: "+obj.addOperation(10, 20, 30));
        System.out.println("Sum of four numbers: "+obj.addOperation(1,  2, 3, 4));
    }

    int addOperation(int num1, int num2) {
        return num1+num2;
    }
    
    int addOperation(int num1, int num2, int num3) {
        return num1+num2+num3;
    }
    
    int addOperation(int num1, int num2, int num3, int num4) {
        return num1+num2+num3+num4;
    }
    
}
