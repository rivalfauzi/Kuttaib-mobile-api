package com.kuttaib.kuttaib_api.feature.juz.services;

import com.kuttaib.kuttaib_api.domain.quran.repository.JuzRepository;
import com.kuttaib.kuttaib_api.feature.juz.responses.JuzListResponse;

import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Service;

@Service 
@RequiredArgsConstructor 
public class JuzServices {
    private final JuzRepository juzRepository;

    public List<JuzListResponse> getList() {
        return juzRepository
            .findAll()
            .stream()
            .map(JuzListResponse::from)
            .toList();
    }
}
