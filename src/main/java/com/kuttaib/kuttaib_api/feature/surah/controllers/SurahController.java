package com.kuttaib.kuttaib_api.feature.surah.controllers;

import com.kuttaib.kuttaib_api.feature.surah.responses.SurahListResponse;
import com.kuttaib.kuttaib_api.feature.surah.services.SurahServices;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;


@RestController 
@RequestMapping("/api/surah")
@RequiredArgsConstructor
public class SurahController {
    private final SurahServices surahServices;

    @GetMapping("/list")
    public List<SurahListResponse> getSurah() {
        return surahServices.getList();
    }
}