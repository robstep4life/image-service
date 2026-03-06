package com.example.imageservice.config;

import com.example.imageservice.model.User;
import com.example.imageservice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner ensureDefaultAdmin(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> userRepository.findByUsername("admin")
                .ifPresentOrElse(existingAdmin -> {
                    String storedPassword = existingAdmin.getPassword();
                    if (storedPassword == null || !storedPassword.startsWith("$2")) {
                        existingAdmin.setPassword(passwordEncoder.encode("Robstep6768@"));
                        userRepository.save(existingAdmin);
                    }
                }, () -> {
                    User admin = new User();
                    admin.setUsername("admin");
                    admin.setPassword(passwordEncoder.encode("Robstep6768@"));
                    userRepository.save(admin);
                });
    }
}
