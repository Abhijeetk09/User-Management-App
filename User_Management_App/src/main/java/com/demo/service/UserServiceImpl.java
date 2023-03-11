package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.UserDetails;
import com.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository ur;
	
	
	@Override
	public UserDetails createUser(UserDetails user) {
		return ur.save(user);
	}


	@Override
	public boolean checkEmail(String email) {
		
		return ur.existsByEmail(email);
	}

	
	
}
