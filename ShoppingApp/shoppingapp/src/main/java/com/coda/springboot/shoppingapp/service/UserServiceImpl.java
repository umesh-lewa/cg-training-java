package com.coda.springboot.shoppingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coda.springboot.shoppingapp.model.User;
import com.coda.springboot.shoppingapp.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findByUsername(String uname) {

		System.out.println("userRepository in UserServiceImpl : "+userRepository);
		return userRepository.findByUsername(uname);
	}

	@Override
	public void save(User user) {
		
		/*
		user.setUname(user.getUpass());
		user.setUpass(user.getUpass());	
		user.setFlag(user.getFlag());
		*/
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		userRepository.save(user);		
	}

}
