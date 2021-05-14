package comcom.avnet;

public class SpringDemo {

	public static void main(String[] args) {
		Object human = (Human)FrameworkService.getService("humanInstance");
		Human xPerson = (Human)human;
		xPerson.seeHuman();
		xPerson.growHuman();
		xPerson.getxPersonDoctor().doCure();
		xPerson.getxPersonEngineer().doEngineer();
	}
}
