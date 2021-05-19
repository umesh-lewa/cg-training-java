package controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("hello")
public class HelloController {
	
	@RequestMapping(value="hai", method = RequestMethod.GET)
	public void sayHello() {
		System.out.println("say Hello method called....");
	}
	
	@RequestMapping(value="hai2", method = RequestMethod.GET)
	public String sayHello2() {
		System.out.println("say Hello method called....");
		return "welcome";
	}
	
	@RequestMapping(value="hai3", method = RequestMethod.GET)
	public ModelAndView sayHello3() {
		System.out.println("say Hello method 333  called....");
		ModelAndView mandv=new ModelAndView();
		mandv.setViewName("welcome");
		mandv.addObject("msg","Welcome to spring...........MVC.....");
		return mandv;
	}
	
	@RequestMapping(value="hai4", method = RequestMethod.GET)
	public ModelAndView sayHello4(ModelAndView mandv) {
		mandv.setViewName("welcome");
		mandv.addObject("msg","Welcome to spring...........MVC 44444444444444.....");
		return mandv;
	}
	
	@RequestMapping(value="hai5", method = RequestMethod.GET)
	public ModelAndView sayHello5(ModelAndView mandv,HttpServletRequest request) {
		mandv.setViewName("welcome");
		mandv.addObject("msg","Welcome to spring...........MVC 44444444444444.....");
		request.setAttribute("msgtwo", " This is message 2222222222222222222.............");
		return mandv;
	}
	
	@RequestMapping(value="hai6/{uname}", method = RequestMethod.GET)
	public ModelAndView sayHello6(ModelAndView mandv,HttpServletRequest request,@PathVariable("uname") String uname) {
		mandv.setViewName("welcome");
		System.out.println("the path param value......:"+uname);
		mandv.addObject("msg","Welcome to spring...........MVC 44444444444444.....");
		request.setAttribute("msgtwo", " This is message 2222222222222222222............."+uname);
		employee.doBusiness();
		return mandv;
	}	
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Autowired
	private Employee employee;
	
}

@Component
class Employee {
	public void doBusiness() {
		System.out.println("do business called for employee........");
		empService.doService();
	}
	public EmpService getEmpService() {
		return empService;
	}
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	@Autowired
	private EmpService empService;
}

@Service
class EmpService{
	@Autowired
	private EmpRepo empRepo;

	public EmpRepo getEmpRepo() {
		return empRepo;
	}

	public void setEmpRepo(EmpRepo empRepo) {
		this.empRepo = empRepo;
	}
	
	public void doService() {
		System.out.println("do service method called.....");
		empRepo.findMethod();
	}
}

@Repository
class EmpRepo{
	public void findMethod() {
		System.out.println("all emp records found.........");
	}
}