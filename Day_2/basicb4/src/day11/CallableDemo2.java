package day11;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo2 {
	
	public static void main(String[] args)throws Exception {
		
		ExecutorService es=Executors.newFixedThreadPool(1);
		
		Future f=es.submit(new MyCallable1());
		try {Thread.sleep(500);}catch(Exception e) {}
		System.out.println("main thread....");
		String s=(String)f.get();
		
		System.out.println(s);
		
		
		es.shutdown();
	}
	
}

class MyCallable1 implements Callable{
	
	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("call called....");
		try {Thread.sleep(2000);}catch(Exception e) {}
		return "hello world";
	}
	
}