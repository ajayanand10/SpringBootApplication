package com.ajay.springboot.controller;

import com.ajay.springboot.entity.User;
import com.ajay.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> getUser(){
        List<User> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    @PostMapping("/")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/email")
    public ResponseEntity<?> getUser(@RequestParam String email){
        User userDb = userService.getUser(email);
        return ResponseEntity.ok(userDb);
    }
}
