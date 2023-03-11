package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.model.UserDetails;
import com.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
  
	@Autowired
	private UserService us;
	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/signin")
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/createUser")
	public String createUser(@ModelAttribute UserDetails user, HttpSession session) {
	//	System.out.println(user);
		
		boolean f = us.checkEmail(user.getEmail());
		
		if(f) {
			session.setAttribute("msg", "Email Id Already Exists");
		}
		else {
			UserDetails ud = us.createUser(user);
			if(ud != null) {
				session.setAttribute("msg", "Register Sucessfully");
			}
			else {
				session.setAttribute("msg", "Somthing Wrong Here ");
			}
		}
		return "redirect:/register";
	}
}
