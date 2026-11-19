package com.kuttaib.kuttaib_api.feature.users.controller;

import com.kuttaib.kuttaib_api.domain.users.entity.User;
import com.kuttaib.kuttaib_api.domain.users.entity.UserRole;
import com.kuttaib.kuttaib_api.domain.users.repository.UserRepository;

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