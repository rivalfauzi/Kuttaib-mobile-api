package com.kuttaib.kuttaib_api.feature.target.services;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.kuttaib.kuttaib_api.feature.target.response.CreateOnboardingTarget;

@Service 
@RequiredArgsConstructor 
public class TargetServices {
    
    public CreateOnboardingTarget createOnboardingTarget() {
        return CreateOnboardingTarget.builder()
            .id(UUID.randomUUID())
            .target("String")
            .targetDailyTime(5)
            .targetType("nulll")
            .totalTarget(10)
            .estimation(20)
            .build();
    }
}
