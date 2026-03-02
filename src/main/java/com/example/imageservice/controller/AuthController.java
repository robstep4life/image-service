package com.example.imageservice.controller;

import com.example.imageservice.model.User;
import com.example.imageservice.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginRequest) {
        String username = loginRequest.getUsername();
        Optional<User> optionalUser = authService.getUserByUsername(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // validate password, generate JWT etc.
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("User not found");
        }
    }
}
