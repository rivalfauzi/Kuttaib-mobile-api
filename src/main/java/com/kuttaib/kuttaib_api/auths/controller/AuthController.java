package com.kuttaib.kuttaib_api.auths.controller;

import com.kuttaib.kuttaib_api.auths.request.RegisterRequest;
import com.kuttaib.kuttaib_api.auths.response.RegisterResponse;
import com.kuttaib.kuttaib_api.auths.service.AuthService;
import com.kuttaib.kuttaib_api.commons.response.ApiResponse;
import com.kuttaib.kuttaib_api.commons.response.ResponseFactory;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ApiResponse<RegisterResponse> register(@Valid @RequestBody RegisterRequest request) {
        RegisterResponse response = authService.register(request);

        return ResponseFactory.success("Register success", response);
    }
}