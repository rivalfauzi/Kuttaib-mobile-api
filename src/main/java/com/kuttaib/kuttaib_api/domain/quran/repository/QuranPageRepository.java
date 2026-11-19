package com.kuttaib.kuttaib_api.domain.quran.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuttaib.kuttaib_api.domain.quran.entity.QuranPage;

import java.util.UUID;

public interface QuranPageRepository
        extends JpaRepository<QuranPage, UUID> {

}