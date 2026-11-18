package com.kuttaib.kuttaib_api.quran.repository;

import com.kuttaib.kuttaib_api.quran.entity.Juz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JuzRepository
        extends JpaRepository<Juz, UUID> {

    Optional<Juz> findByNumber(
            Integer number
    );

}