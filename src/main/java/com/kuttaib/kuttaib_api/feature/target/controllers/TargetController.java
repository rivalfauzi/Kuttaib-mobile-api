package com.kuttaib.kuttaib_api.feature.target.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.kuttaib.kuttaib_api.feature.target.request.CreateOnboardingRequest;
import com.kuttaib.kuttaib_api.feature.target.response.CreateOnboardingTarget;
import com.kuttaib.kuttaib_api.feature.target.services.TargetServices;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController 
@RequestMapping("/api/target")
@RequiredArgsConstructor 
public class TargetController {
    private final TargetServices targetServices;

    @PostMapping("/create-onboarding")
    public CreateOnboardingTarget createOnboardingTarget(
        @Valid @RequestBody CreateOnboardingRequest target
    ) {
        return targetServices.createOnboardingTarget(target);
    }
    
}
