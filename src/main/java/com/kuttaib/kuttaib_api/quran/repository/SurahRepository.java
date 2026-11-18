package com.kuttaib.kuttaib_api.quran.repository;

import com.kuttaib.kuttaib_api.quran.entity.Surah;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SurahRepository
        extends JpaRepository<Surah, UUID> {

    Optional<Surah> findByNumber(
            Integer number
    );
}