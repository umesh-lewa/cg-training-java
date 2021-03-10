package test1;

class Base{
    Base(int i){
    System.out.println("base constructor");
    }
    Base(){
    }
}
public class Sup extends Base{
    public static void main(String argv[]){
         Sup s= new Sup();
    //One
    }
    Sup()
    {
        //Two
    	super(10);
    }
    public void derived()
    {
        //Three
    }
}