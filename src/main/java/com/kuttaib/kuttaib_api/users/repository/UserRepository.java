package com.kuttaib.kuttaib_api.users.repository;

import com.kuttaib.kuttaib_api.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    
}