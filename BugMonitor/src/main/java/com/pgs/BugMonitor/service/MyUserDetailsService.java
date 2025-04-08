package com.pgs.BugMonitor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pgs.BugMonitor.entity.UserPrincipal;
import com.pgs.BugMonitor.entity.Users;
import com.pgs.BugMonitor.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Users user = userRepo.findByEmail(username);
		System.out.println("Attempting to load user with email " + user.getEmail());
		
		if(user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("User not found");
		}
		
		UserPrincipal userPrincipal = new UserPrincipal(user);
		
		System.out.println(userPrincipal.getPassword());
		
		return new UserPrincipal(user);
	}
	
}
