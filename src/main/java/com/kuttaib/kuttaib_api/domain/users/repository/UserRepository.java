package com.kuttaib.kuttaib_api.domain.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuttaib.kuttaib_api.domain.users.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    
}