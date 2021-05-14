package comcom.avnet;

import java.util.logging.Logger;

public class Human {

	private static final String CLASS_NAME = Human.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);
	
	
	private Doctor xPersonDoctor ; 
	private Engineer xPersonEngineer;
	

	public void seeHuman() {
		String methodName = "seeHuman";
		logger.entering(CLASS_NAME, methodName);
		logger.info("seeHuman method is called");
		logger.exiting(CLASS_NAME, methodName);
	}
	public void growHuman(){
		String methodName = "growHuman";
		logger.entering(CLASS_NAME, methodName);
		logger.info("growHuman method is called");
		logger.exiting(CLASS_NAME, methodName);
	}
	public Doctor getxPersonDoctor() {
		return xPersonDoctor;
	}
	public void setxPersonDoctor(Doctor xPersonDoctor) {
		this.xPersonDoctor = xPersonDoctor;
	}
	public Engineer getxPersonEngineer() {
		return xPersonEngineer;
	}
	public void setxPersonEngineer(Engineer xPersonEngineer) {
		this.xPersonEngineer = xPersonEngineer;
	}
}
