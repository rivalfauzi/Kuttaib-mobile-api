package com.kuttaib.kuttaib_api.feature.users.controller;

import com.kuttaib.kuttaib_api.domain.users.entity.User;
import com.kuttaib.kuttaib_api.domain.users.repository.UserRepository;
import com.kuttaib.kuttaib_api.feature.users.request.CreateUserRequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

   @PostMapping
    public User createUser(@Valid @RequestBody CreateUserRequest request) {

        User user = User.builder()
                .username(request.getUsername())
                .role(request.getRole())
                .dailyVerseTarget(request.getDailyVerseTarget() != null ? request.getDailyVerseTarget() : 0)
                .build();

        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
