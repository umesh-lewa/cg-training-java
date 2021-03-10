package test1;

/*
abstract class MineBase { 
    abstract void amethod(); 
    static int i; 
}
public class Mine extends MineBase      { 
    public static void main(String argv[]){ 
                    int[] ar=new int[5]; 
                    for(i=0;i < ar.length;i++) 
                            System.out.println(ar[i]); 
                    } 
}

*/

import java.io.*; 
public class Mine { 
        public static void main(String argv[]){
        Mine m=new Mine(); 
        System.out.println(m.amethod()); 
}
public int amethod() { 
        try {
                FileInputStream dis=new FileInputStream("Hello.txt"); 
                }catch (FileNotFoundException fne) { 
                        System.out.println("No such file found"); 
                        return -1; 
                        }catch(IOException ioe) { 
                        } finally{ 
        System.out.println("Doing finally"); 
        } 
        return 0; 
        } 
}