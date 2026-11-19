package com.kuttaib.kuttaib_api.feature.juz.controllers;

import com.kuttaib.kuttaib_api.feature.juz.responses.JuzListResponse;
import com.kuttaib.kuttaib_api.feature.juz.services.JuzServices;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@RestController 
@RequestMapping("api/juz")
@RequiredArgsConstructor 
public class JuzControllers {
    private final JuzServices juzServices;

    @GetMapping("/list")
    public List<JuzListResponse> getJuz() {
        return juzServices.getList();
    }
    
}
