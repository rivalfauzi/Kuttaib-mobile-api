package com.kuttaib.kuttaib_api.domain.quran.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuttaib.kuttaib_api.domain.quran.entity.Ayah;

import java.util.List;
import java.util.UUID;

public interface AyahRepository
        extends JpaRepository<Ayah, UUID> {

    List<Ayah> findBySurahNumberOrderByVerseNumberAsc(
            Integer surahNumber
    );

}