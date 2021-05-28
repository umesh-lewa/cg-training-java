package com.coda.springboot.shoppingapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coda.springboot.shoppingapp.config.UserValidator;
import com.coda.springboot.shoppingapp.model.Item;
import com.coda.springboot.shoppingapp.model.User;
import com.coda.springboot.shoppingapp.service.ShopService;
import com.coda.springboot.shoppingapp.service.ShopServiceImpl;
import com.coda.springboot.shoppingapp.service.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private ShopServiceImpl shopService;
	
	@Autowired
    private UserValidator userValidator;
	
	/*
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkUser() {
		
		return "welcomePage";
	}
	*/
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }
	
	@PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
		
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        //return "redirect:/welcome";
        return "registrationSuccess";
    }
	
	@GetMapping("/login")
    public String login(Model model, String error, String logout) {
		
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
	
	@GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
		
        return "welcome";
    }
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    //return "redirect:/login?logout";
	    return "logoutSuccess";
	}
	
	//HttpServletRequest request
	
	//@PostMapping({"/doshop1"})
	@RequestMapping(value="/doshop", method=RequestMethod.POST)
	public String doShop(Model model,HttpServletRequest request) {
		
		System.out.println("Inside POST /doShop1....!!!");
		
		String next = shopService.doShop(request);
		
		return next;
				
		//return "shop2";
	}
	
	@GetMapping({"/doshop"}) 
    public String getDoShop(Model model) {
		
		System.out.println("Inside GET /doShop....!!!");
		
		System.out.println("shopService : "+shopService);
    	List<Item> items = shopService.findItemsByItemtype("vegetable");
    
    	
    	for(Item item:items) {
    		System.out.println(item.getItem_name()+" : "+"<input type='checkbox' name="+item.getItemid()+" value="+item.getItem_name()+","+item.getItem_unit()+","+item.getPrice()+" >");
    	}
  	
        return "shop1";
    }
	
	@GetMapping({"/viewinvoices"}) 
    public String getInvoiceList(Model model) {
		
		System.out.println("Inside GET /viewinvoices....!!!");
  	
        return "invoicelist";
    }
	/*
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String createUser(HttpServletRequest request) {
		
		User user = new User();
		user.setUname(request.getParameter("uname"));
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(request.getParameter("upass"));
	    user.setUpass(encodedPassword);
	     	   
		userService.saveUser(user);
		
		return "loginPage";
	}
	*/
	
	
}
