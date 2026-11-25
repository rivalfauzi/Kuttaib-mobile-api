package com.kuttaib.kuttaib_api.feature.juz.controllers;

import com.kuttaib.kuttaib_api.commons.constants.ApiPath;
import com.kuttaib.kuttaib_api.commons.response.ApiResponse;
import com.kuttaib.kuttaib_api.commons.response.ResponseFactory;
import com.kuttaib.kuttaib_api.feature.juz.responses.JuzListResponse;
import com.kuttaib.kuttaib_api.feature.juz.services.JuzServices;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@RestController 
@RequestMapping(ApiPath.JUZ)
@RequiredArgsConstructor 
public class JuzControllers {
    private final JuzServices juzServices;

    @GetMapping("/list")
    public ApiResponse<List<JuzListResponse>> getJuz() {
        return ResponseFactory.success(juzServices.getList());
    }
    
}
