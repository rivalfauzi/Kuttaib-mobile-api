package com.kuttaib.kuttaib_api.feature.surah.services;

import com.kuttaib.kuttaib_api.domain.quran.repository.SurahRepository;
import com.kuttaib.kuttaib_api.feature.surah.responses.SurahListResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor 
public class SurahServices {
    private final SurahRepository surahRepository;

    public List<SurahListResponse> getList() {
        return surahRepository
            .findAll()
            .stream()
            .map(SurahListResponse::from)
            .toList();
    }

}
