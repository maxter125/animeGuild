package com.spring.Ibento.controller;

import com.spring.Ibento.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Thread> getThreadById(@PathVariable int id) {
        return threadRepository.findById(id)
                .map(thread -> ResponseEntity.ok().body(thread))
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint to add a new thread
    @PostMapping
    public ResponseEntity<Thread> addThread(@RequestBody Thread thread) {
        Thread newThread = threadRepository.save(thread);
        return ResponseEntity.status(HttpStatus.CREATED).body(newThread);
    }

    // Endpoint to delete a thread by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteThreadById(@PathVariable int id) {
        if (threadRepository.existsById(id)) {
            threadRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Other endpoints for thread management (e.g., update) can be added here
}
