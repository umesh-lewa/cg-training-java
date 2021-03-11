package labbook1;

import java.util.Arrays;

public class Q16 {
	
	public static void main(String args[]) {
		
		int arr[] = { 1,23,44,3,14,89,44 }; 
		  
        int element = 44; 
 
        checkElement(arr, element); 
	}
	
	private static void checkElement(int[] arr, int toCheckValue) { 

        boolean isPresent = false;
        int count = 0;
        
        for (int element : arr) { 
            if (element == toCheckValue) { 
            	isPresent = true;
            	count++;
            } 
        } 
  
        if(isPresent) {
        	System.out.println("Element is present");
        	System.out.println("Count : "+count); 
        }else {
        	System.out.println("Element is not present");
        }
        
    } 

}
