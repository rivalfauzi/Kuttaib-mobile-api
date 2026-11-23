package com.kuttaib.kuttaib_api.feature.users.response;

import com.kuttaib.kuttaib_api.domain.users.entity.User;
import com.kuttaib.kuttaib_api.domain.users.entity.UserRole;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter 
@Setter 
@Builder
public class CreateGuestUserResponse {
    private UUID id;
    private UserRole role;

    public static  CreateGuestUserResponse from(User target) {
        return CreateGuestUserResponse.builder()
            .id(target.getId())
            .role(target.getRole())
            .build();
    }
}