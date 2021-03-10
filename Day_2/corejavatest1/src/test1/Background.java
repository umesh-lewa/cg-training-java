package test1;

class Background implements Runnable{ 
	  int i=0; 
	  public int run(){ 
	         while(true){ 
	                i++; 
	                System.out.println("i="+i); 
	            } //End while

	     return 1;
	     }//End run 
	}//End class