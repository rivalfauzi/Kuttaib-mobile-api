package com.kuttaib.kuttaib_api.feature.users.controller;

import com.kuttaib.kuttaib_api.feature.users.response.CreateGuestUserResponse;
import com.kuttaib.kuttaib_api.feature.users.services.UserServices;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/onboarding/guests")
@RequiredArgsConstructor
public class GuestController {

    private final UserServices userServices;

    @PostMapping
    public CreateGuestUserResponse createGuest() {
        return userServices.createGuest();
    }
}