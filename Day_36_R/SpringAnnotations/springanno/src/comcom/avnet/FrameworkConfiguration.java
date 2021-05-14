package comcom.avnet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;

@Configuration
@EnableAspectJAutoProxy
@Profile("default")
public class FrameworkConfiguration {

	protected Human xPerson;
	protected FrameworkAspect frameworkAspect;
	protected Doctor doctor;
	protected Engineer engineer;

	@Bean(name = "humanInstance")
	public Human getHuman() {
		if (xPerson == null) {
			xPerson = new Human();
			xPerson.setxPersonDoctor(getDoctorInstance());
			xPerson.setxPersonEngineer(getEngineerInstance());
		}
		return xPerson;
	}

	@Bean
	public Doctor getDoctorInstance() {
		if (doctor == null) {
			doctor = new MedicalCollege();
		}
		return doctor;
	}

	@Bean
	public Engineer getEngineerInstance() {
		if (engineer == null) {
			engineer = new EngineeringCollege();
		}
		return engineer;
	}

	@Bean
	public FrameworkAspect getAspect() {
		if (frameworkAspect == null) {
			frameworkAspect = new FrameworkAspect();
		}
		return frameworkAspect;
	}
}
