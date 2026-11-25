package com.kuttaib.kuttaib_api.feature.surah.controllers;

import com.kuttaib.kuttaib_api.commons.constants.ApiPath;
import com.kuttaib.kuttaib_api.commons.response.ApiResponse;
import com.kuttaib.kuttaib_api.commons.response.ResponseFactory;
import com.kuttaib.kuttaib_api.feature.surah.responses.SurahListResponse;
import com.kuttaib.kuttaib_api.feature.surah.services.SurahServices;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController 
@RequestMapping(ApiPath.SURAH)
@RequiredArgsConstructor
public class SurahController {
    private final SurahServices surahServices;

    @GetMapping("/list")
    public ApiResponse<List<SurahListResponse>> getSurah() {
        return ResponseFactory.success(surahServices.getList());
    }
}