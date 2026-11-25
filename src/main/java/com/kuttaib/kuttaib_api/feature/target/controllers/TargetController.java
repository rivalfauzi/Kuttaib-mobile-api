package com.kuttaib.kuttaib_api.feature.target.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.kuttaib.kuttaib_api.commons.constants.ApiPath;
import com.kuttaib.kuttaib_api.commons.response.ApiResponse;
import com.kuttaib.kuttaib_api.commons.response.ResponseFactory;
import com.kuttaib.kuttaib_api.feature.target.request.CreateOnboardingRequest;
import com.kuttaib.kuttaib_api.feature.target.response.CreateOnboardingTarget;
import com.kuttaib.kuttaib_api.feature.target.services.TargetServices;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController 
@RequestMapping(ApiPath.TARGETS)
@RequiredArgsConstructor 
public class TargetController {
    private final TargetServices targetServices;

    @PostMapping("/create-onboarding")
    public ApiResponse<CreateOnboardingTarget> createOnboardingTarget(
        @Valid @RequestBody CreateOnboardingRequest target
    ) {
        return ResponseFactory.success(targetServices.createOnboardingTarget(target));
    }
    
}
