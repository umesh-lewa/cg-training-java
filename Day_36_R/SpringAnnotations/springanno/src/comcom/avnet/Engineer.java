package comcom.avnet;

import java.util.logging.Logger;

public interface Engineer {
	void doEngineer();
}

class EngineeringCollege implements Engineer {

	private static final String CLASS_NAME = EngineeringCollege.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	@Override
	public void doEngineer() {
		String methodName = "doEngineer";
		logger.entering(CLASS_NAME, methodName);
		logger.info("doEngineer method Called");
		logger.exiting(CLASS_NAME, methodName);
	}
}
