package com.kuttaib.kuttaib_api.quran.repository;

import com.kuttaib.kuttaib_api.quran.entity.QuranPage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuranPageRepository
        extends JpaRepository<QuranPage, UUID> {

}