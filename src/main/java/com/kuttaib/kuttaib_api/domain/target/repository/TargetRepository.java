package com.kuttaib.kuttaib_api.domain.target.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kuttaib.kuttaib_api.domain.target.entity.Target;
import java.util.UUID;

public interface TargetRepository extends JpaRepository<Target, UUID> {
    
}