package com.kuttaib.kuttaib_api.feature.users.request;

import com.kuttaib.kuttaib_api.domain.users.entity.UserRole;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {

    @NotBlank
    private String username;

    @NotNull
    private UserRole role;

    private Integer dailyVerseTarget;
}