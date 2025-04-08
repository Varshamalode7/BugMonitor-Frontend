package com.pgs.BugMonitor.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pgs.BugMonitor.entity.Users;
import com.pgs.BugMonitor.repo.UserRepo;
import com.pgs.BugMonitor.service.UserService;

@RestController
public class BugMonitorController {
	
	 @Autowired
	 private UserRepo userRepo;
	 
	 @Autowired
	 private UserService userService;
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello";
	}
	
	//create
	@PostMapping("/register")
	public Users addUser(@RequestBody Users theUser) {
		return userService.registerUser(theUser);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Users theUser) {
		return userService.login(theUser);
	}
	
	
	

}
