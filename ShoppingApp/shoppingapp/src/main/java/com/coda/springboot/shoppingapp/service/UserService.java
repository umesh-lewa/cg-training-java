package com.coda.springboot.shoppingapp.service;

import com.coda.springboot.shoppingapp.model.User;

public interface UserService {

	public User findByUsername(String uname);
	 
	public void save(User user);
	
}
