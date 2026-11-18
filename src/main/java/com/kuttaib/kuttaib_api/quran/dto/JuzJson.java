package com.kuttaib.kuttaib_api.quran.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JuzJson {

    private Integer startSurah;
    private Integer startAyah;

    private Integer endSurah;
    private Integer endAyah;

    private Integer startPage;
    private Integer endPage;
}