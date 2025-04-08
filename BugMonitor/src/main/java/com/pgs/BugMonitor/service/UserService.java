package com.pgs.BugMonitor.service;
import com.pgs.BugMonitor.entity.Users;
import com.pgs.BugMonitor.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JWTService jwtService;
	
	
	
	private BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(12);


	public Users registerUser(Users user) {
		user.setPassword(bcrypt.encode(user.getPassword()));
		userRepo.save(user);
		return user;
	}
	
	public String login(Users user) {
		
		Authentication authObject = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
		if(authObject.isAuthenticated()) {
			return jwtService.generateToken(user.getEmail());
		}else {
			
		}
		return "Success";
	}

}
