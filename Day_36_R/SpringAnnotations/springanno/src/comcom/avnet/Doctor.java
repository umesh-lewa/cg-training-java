package comcom.avnet;

import java.util.logging.Logger;

public interface Doctor {
	 void doCure();
}

class MedicalCollege implements Doctor {
	private static final String CLASS_NAME = MedicalCollege.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);

	@Override
	public void doCure() {
		String methodName = "doCure";
		logger.entering(CLASS_NAME, methodName);
		logger.info("Cure method Called");
		logger.exiting(CLASS_NAME, methodName);
	}
}