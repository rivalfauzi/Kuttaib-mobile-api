package com.kuttaib.kuttaib_api.feature.users.controller;

import com.kuttaib.kuttaib_api.commons.response.ApiResponse;
import com.kuttaib.kuttaib_api.commons.response.ResponseFactory;
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
    public ApiResponse<CreateGuestUserResponse> createGuest() {
        return ResponseFactory.success(userServices.createGuest());
    }
}