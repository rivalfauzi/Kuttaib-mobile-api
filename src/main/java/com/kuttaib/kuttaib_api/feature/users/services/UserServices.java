package com.kuttaib.kuttaib_api.feature.users.services;

import com.kuttaib.kuttaib_api.domain.users.entity.User;
import com.kuttaib.kuttaib_api.domain.users.entity.UserRole;
import com.kuttaib.kuttaib_api.domain.users.repository.UserRepository;
import com.kuttaib.kuttaib_api.feature.users.response.CreateGuestUserResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service 
@RequiredArgsConstructor 
public class UserServices {
    private final UserRepository userRepository;

    public CreateGuestUserResponse createGuest() {
        User user = User.builder()
                .role(UserRole.GUEST)
                .build();

        User savedUser = userRepository.save(user);

        return CreateGuestUserResponse.from(savedUser);
    }
}