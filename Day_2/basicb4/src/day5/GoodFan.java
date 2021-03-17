package day5;

public class GoodFan {
	
	public static void main(String args[]) {
		
		Fan fan =new Fan();
		
		System.out.println("default state : "+fan.getStateValue());
		
		fan.pull(new State1());
		
		System.out.println("after pull state : "+fan.getStateValue());
		
		fan.turnOff();
		
		System.out.println("after off state : "+fan.getStateValue());
		
	}
	
}

class Fan{
	
	State state;
	int stateValue = 0;
	
	public void pull(State state) {
		this.state = state;
		this.stateValue = state.getStateValue();
	}
	
	public void turnOff() {
		this.state = new State0();
		this.stateValue = 0;
	}
	
	public int getStateValue() {
		return this.stateValue;
	}
}

abstract class State{
	
	public abstract int getStateValue();
}

class State0 extends State{
	
	private int stateValue = 0;
	
	public int getStateValue() {
		return this.stateValue;
	}
	
}

class State1 extends State{
	
	private int stateValue = 1;
	
	public int getStateValue() {
		return this.stateValue;
	}
	
}

class State2 extends State{
	
	private int stateValue = 2;
	
	public int getStateValue() {
		return this.stateValue;
	}
	
}
