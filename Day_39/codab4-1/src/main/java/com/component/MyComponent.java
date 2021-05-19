package com.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.User;
import com.service.UserService;

@Component
public class MyComponent {
	@Autowired
	private UserService myservice;

	public UserService getMyservice() {
		return myservice;
	}

	public void setMyservice(UserService myservice) {
		this.myservice = myservice;
	}
	
	public void addUser() {
		User user=new User();
		user.setUid(100);
		user.setUname("ramu");
		user.setUpass("spider");
		myservice.createUser(user);
	}
}
