package test1;

private class Base{
Base(){
     int i = 100;     
     System.out.println(i);
     }
}
public class Pri extends Base{
static int i = 200;
public static void main(String argv[]){
        Pri p = new Pri();
        System.out.println(i);
        }
}
