package com.kuttaib.kuttaib_api.quran.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class AyahResponse {

    private Integer nomorAyat;

    private String teksArab;

    private String teksLatin;

    private String teksIndonesia;

    private Map<String, String> audio;
}