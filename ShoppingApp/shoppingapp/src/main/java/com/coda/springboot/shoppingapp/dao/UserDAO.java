package com.coda.springboot.shoppingapp.dao;

import com.coda.springboot.shoppingapp.model.User;

public abstract class UserDAO {
	
	public abstract void createUser(User user);
	
	public abstract void checkUser(User user);
	
}

