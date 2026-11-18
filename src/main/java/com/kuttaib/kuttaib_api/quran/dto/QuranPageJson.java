package com.kuttaib.kuttaib_api.quran.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuranPageJson {

    private Integer page;

    private Integer startSurah;
    private Integer startAyah;

    private Integer startAyahNumber;

    private Integer endSurah;
    private Integer endAyah;

    private Integer endAyahNumber;

    private String wisdomId;
    private String wisdomEn;

    private Integer section;
}
