package day14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class CopyCommand {
	
	public static void main(String[] args)throws Exception {
		
		//FileInputStream fis=new FileInputStream("abc.properties");
		//FileOutputStream fos=new FileOutputStream("copyabc.properties",true);
		try (
		FileReader fis=new FileReader("abc.properties");
		FileWriter fos=new FileWriter("copyabc.properties");
			)
		{
		//System.out.println(fis.available());
		
		int i=0;
		//byte b[]=new byte[8];
		char b[]=new char[8];
		
		while((i=fis.read(b))!=-1) {  //now i returns the number of bytes read...
			//System.out.print((char)i+"\t");
			System.out.println("No of bytes read..:"+i);
			String s=new String(b,0,i);
			System.out.println("Value is..:"+s);
			fos.write(b,0,i);
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		//fos.close();
	
		//System.out.println(fis.read());//-1 denotes EOF in java
	}
	
}