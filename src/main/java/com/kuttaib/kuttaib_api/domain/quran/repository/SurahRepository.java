package com.kuttaib.kuttaib_api.domain.quran.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuttaib.kuttaib_api.domain.quran.entity.Surah;

import java.util.Optional;
import java.util.UUID;

public interface SurahRepository
        extends JpaRepository<Surah, UUID> {

    Optional<Surah> findByNumber(
            Integer number
    );
}