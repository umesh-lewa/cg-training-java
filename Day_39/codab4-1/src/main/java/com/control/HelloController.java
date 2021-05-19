package com.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.component.MyComponent;

@Controller
@RequestMapping("/")
public class HelloController {

	@Autowired
	private MyComponent myc;
	
	public MyComponent getMyc() {
		return myc;
	}

	public void setMyc(MyComponent myc) {
		this.myc = myc;
	}
	
	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String sayHello() {
		myc.addUser();
		return "welcome";
	}
}
