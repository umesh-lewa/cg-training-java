package controllers;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@RequestMapping(value="showLoginPage", method=RequestMethod.GET)
	public ModelAndView showLoginPage(ModelAndView mandv) {
		LoginForm loginForm=new LoginForm();
		mandv.addObject("loginForm",loginForm);
		mandv.setViewName("login");
		return mandv;
	}
	
	@RequestMapping(value="submitform", method=RequestMethod.POST)
	public ModelAndView processLoginPage(ModelAndView mandv,@Valid LoginForm loginForm, BindingResult result) {
		if(result.hasErrors()) {
			mandv.setViewName("login");
			return mandv;
		}
		System.out.println(loginForm.getUname()+":"+loginForm.getUpass());
		mandv.addObject("loginBean",loginForm);
		mandv.setViewName("welcome");
		return mandv;
	}
	
}
