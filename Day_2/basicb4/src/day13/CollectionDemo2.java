package day13;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class CollectionDemo2 {
	
	public static void main(String args[]) {
		
		Vector<String> v = new Vector<String>();
		v.add("a");
		v.add("b");
		v.add("c");
		
		Iterator<String> iter = v.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		Enumeration enumr = v.elements();
		
		while(enumr.hasMoreElements()) {
			System.out.println(enumr.nextElement());
		}
		
		
		LinkedList<String> ll = new LinkedList<String>();
		
		Iterator<String> iter2 = ll.iterator(); 
		
		while(iter2.hasNext()) {
			System.out.println(iter2.next());
		}
		
	}

}
