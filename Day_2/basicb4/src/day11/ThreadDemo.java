package day11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {
	
	public ThreadDemo() {
		
		Thread t = new Thread();
		
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.execute(new MyThreadWork());
		es.shutdown();
		
	}
	
	public static void main(String args[]) throws Exception{
		
		new ThreadDemo();
		
		Thread t = Thread.currentThread();
		
		for(int i = 0 ; i < 5 ; i++) {
			System.out.println(i);
			Thread.sleep(1000);
		}
	}

}

class MyThreadWork implements Runnable{

	@Override
	public void run() {
		System.out.println("Child thread called");
		
	}
	
}
