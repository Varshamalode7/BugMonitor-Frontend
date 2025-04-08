package com.pgs.BugMonitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pgs.BugMonitor.entity.Users;
import com.pgs.BugMonitor.repo.UserRepo;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class AdminController {

    @Autowired
    private UserRepo userRepo;

    // View all users
    @GetMapping
    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    // View a single user by ID
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable int id) {
        Optional<Users> user = userRepo.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add a new user
    @PostMapping
    public Users addUser(@RequestBody Users user) {
        return userRepo.save(user);
    }

    // Update an existing user
    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable int id, @RequestBody Users userDetails) {
    	System.out.println("Hello");
        Optional<Users> userOptional = userRepo.findById(id);
        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setRole(userDetails.getRole());
            return ResponseEntity.ok(userRepo.save(user));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

  
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
