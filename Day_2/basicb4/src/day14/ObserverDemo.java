package day14;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ObserverDemo {
	public static void main(String[] args) {
		FireAlarm shakthi=new FireAlarm();
		shakthi.addObserver(new Teacher());
		shakthi.addObserver(new Student());
		
		shakthi.setFire();		
	}
}
class ThreadedObservable extends Observable{
	ExecutorService es;
	public ThreadedObservable() {
		es=Executors.newFixedThreadPool(2);
	}
	ArrayList<Observer> v=new ArrayList<>();
	@Override
		public synchronized void addObserver(Observer o) {
			v.add(o);
		}
	@Override
		public void notifyObservers(Object arg) {
			Iterator<Observer> e=v.iterator();
			while(e.hasNext()) {
				Observer o=e.next();
			es.execute(()->{
				o.update(this, arg);
			});
			}
			es.shutdown();
		}
}
class FireAlarm extends ThreadedObservable{
	public void setFire() {
		setChanged();
		notifyObservers("fire in the mountain run run run..............");//signal is sent
	}
}
class Student implements Observer{
	@Override
	public void update(Observable o, Object arg) {
		runAway((String)arg);
	}
	public void runAway(String msg) {
		System.out.println("students running..........away........"+msg);
	}
}
class Teacher implements Observer{
	@Override
	public void update(Observable o, Object arg) {
		runAway((String)arg);
	}
	public void runAway(String msg) {
		System.out.println("thinking.................");
		try {Thread.sleep(10000);}catch(Exception e) {}
		System.out.println("teacher running...........away........."+msg);
	}
}