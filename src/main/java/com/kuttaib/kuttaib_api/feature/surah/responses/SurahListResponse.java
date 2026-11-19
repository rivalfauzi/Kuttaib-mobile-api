package com.kuttaib.kuttaib_api.feature.surah.responses;

import com.kuttaib.kuttaib_api.domain.quran.entity.Surah;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter 
@Setter 
@Builder
public class SurahListResponse {
    private UUID id;
    private Integer number;
    private String latinName;
    private Integer verseCount;

    public static SurahListResponse from(Surah target) {
        return SurahListResponse.builder()
                .id(target.getId())
                .number(target.getNumber())
                .latinName(target.getLatinName())
                .verseCount(target.getVerseCount())
                .build();
    }
}