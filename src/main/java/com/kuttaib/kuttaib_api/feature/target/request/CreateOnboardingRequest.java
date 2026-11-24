package com.kuttaib.kuttaib_api.feature.target.request;

import com.kuttaib.kuttaib_api.domain.target.entity.TargetType;
import com.kuttaib.kuttaib_api.domain.users.entity.UserDailyTargetType;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class CreateOnboardingRequest {

    @NotNull
    private String userId;

    @NotNull(message = "Target ayah per hari wajib diisi")
    @Min(value = 1, message = "Minimal 1")
    @Max (value = 50, message = "Maksimal 50")
    private Double dailyTarget;

    @NotNull 
    private UserDailyTargetType dailyTargetType;

    @NotNull 
    private Integer targetNumber;

    @NotNull 
    private TargetType targetType;

    private Integer targetTime;
}
