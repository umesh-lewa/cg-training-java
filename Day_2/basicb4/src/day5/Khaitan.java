package day5;

class Khaitan{
	private State1 state;
	
	public final void setState(State1 state) {
		this.state = state;
	}
	
	public Khaitan() {
		this.state=new SwitchOffState();
	}
	
	public void pull() {
		state.pull(this);
	}
	
}
abstract class State1{
	public abstract void pull(Khaitan khaitan);
}
class SwitchOffState extends State1{
	
	@Override
	public void pull(Khaitan khaitan) {
		System.out.println("switch on state.................");
		khaitan.setState(new LowSpeedState());
	}
}
class LowSpeedState extends State1{
	@Override
	public void pull(Khaitan khaitan) {
		System.out.println("low speed state....");
		khaitan.setState(new MediumSpeedState());
	}
}
class MediumSpeedState extends State1{
	@Override
	public void pull(Khaitan khaitan) {
		System.out.println("Medium speed state....");
		khaitan.setState(new HighSpeedState());
	}
}
class HighSpeedState extends State1{
	@Override
	public void pull(Khaitan khaitan) {
		System.out.println("high speed state.....");
		khaitan.setState(new SwitchOffState());
	}
}