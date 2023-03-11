package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Integer>{

	
	public boolean existsByEmail(String email);
}
