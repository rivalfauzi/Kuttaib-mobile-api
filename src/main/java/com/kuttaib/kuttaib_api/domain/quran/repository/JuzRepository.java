package com.kuttaib.kuttaib_api.domain.quran.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuttaib.kuttaib_api.domain.quran.entity.Juz;

import java.util.Optional;
import java.util.UUID;

public interface JuzRepository
        extends JpaRepository<Juz, UUID> {

    Optional<Juz> findByNumber(
            Integer number
    );

}