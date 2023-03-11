package com.demo.service;

import com.demo.model.UserDetails;

public interface UserService {

	
	public UserDetails createUser(UserDetails user);

	public boolean checkEmail(String email);
}
