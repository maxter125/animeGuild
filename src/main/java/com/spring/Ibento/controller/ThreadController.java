package com.spring.Ibento.controller;

import com.spring.Ibento.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.spring.Ibento.model.Thread;
@RestController
@RequestMapping("/api/threads")
public class ThreadController {

    @Autowired
    private ThreadRepository threadRepository;

    // Endpoint to get all threads
    @GetMapping
    public List<Thread> getAllThreads() {
        return threadRepository.findAll();
    }

    // Endpoint to get a thread by ID
    @GetMapping("/{id}")
    public Thread getThreadById(@PathVariable int id) throws Exception {
        return threadRepository.findById(id)
                .orElseThrow(() -> new Exception("Thread not found with id " + id));
    }

    // Other endpoints for thread management (e.g., create, update, delete) can be added here
}
