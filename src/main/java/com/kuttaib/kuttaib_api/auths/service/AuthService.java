package com.kuttaib.kuttaib_api.auths.service;

import com.kuttaib.kuttaib_api.auths.request.RegisterRequest;
import com.kuttaib.kuttaib_api.auths.response.RegisterResponse;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public RegisterResponse register(RegisterRequest request) {
        return new RegisterResponse(
                request.name(),
                request.email()
        );
    }
}
