package com.kuttaib.kuttaib_api.quran.repository;

import com.kuttaib.kuttaib_api.quran.entity.Ayah;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AyahRepository
        extends JpaRepository<Ayah, UUID> {

    List<Ayah> findBySurahNumberOrderByVerseNumberAsc(
            Integer surahNumber
    );

}