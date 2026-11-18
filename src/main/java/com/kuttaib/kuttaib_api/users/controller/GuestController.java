package com.kuttaib.kuttaib_api.users.controller;

import com.kuttaib.kuttaib_api.users.entity.User;
import com.kuttaib.kuttaib_api.users.repository.UserRepository;
import com.kuttaib.kuttaib_api.users.entity.UserRole;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guests")
@RequiredArgsConstructor
public class GuestController {

    private final UserRepository userRepository;

    @PostMapping
    public User createGuest() {

        User user = User.builder()
                .role(UserRole.GUEST)
                .build();

        return userRepository.save(user);
    }
}