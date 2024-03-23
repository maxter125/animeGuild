package com.spring.Ibento.controller;

import com.spring.Ibento.model.User;
import com.spring.Ibento.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Endpoint to get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Endpoint to get a user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) throws Exception {
        return userRepository.findById(id)
                .orElseThrow(() -> new Exception("User not found with id " + id));
    }

    // Other endpoints for user management (e.g., create, update, delete) can be added here
}
