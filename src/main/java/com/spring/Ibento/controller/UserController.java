package com.spring.Ibento.controller;

import com.spring.Ibento.Utility.ResponseHelper;
import com.spring.Ibento.model.User;
import com.spring.Ibento.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseHelper.createResponse(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return userRepository.findById(id)
                .map(user -> ResponseHelper.createResponse(user, HttpStatus.OK))
                .orElseGet(() -> ResponseHelper.createErrorResponse("User not found with id " + id, HttpStatus.NOT_FOUND));
    }

    // Other endpoints for user management (e.g., create, update, delete) can be added here
}