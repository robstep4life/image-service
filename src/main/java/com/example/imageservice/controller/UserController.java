package com.example.imageservice.controller;

import com.example.imageservice.model.User;
import com.example.imageservice.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<String> listUsers() {
        return userRepository.findAll()
                .stream()
                .map(User::getUsername)
                .toList();
    }
}
