package com.assignment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.exception.ResourceNotFoundException;
import com.assignment.model.Model;
import com.assignment.service.ServiceClass;

@RestController
@RequestMapping("/api/users")
public class Controller {

    @Autowired
    private ServiceClass service;

    @GetMapping
    public List<Model> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Model> getUserById(@PathVariable int id) {
        Model user = service.getUserById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
        return ResponseEntity.ok(user);
    } //retrieve user by user_id

    @GetMapping("/username/{username}")
    public ResponseEntity<?> getUserByUsernamePath(@PathVariable String username) {
        Optional<Model> user = service.getUserByUsername(username);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    } //retrieve user by username.

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody Model user) {
        try {
            service.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register user.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Model> updateUser(@PathVariable int id, @RequestBody Model userDetails) {
        Model updatedUser = service.updateUser(id, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
