package com.kuttaib.kuttaib_api.feature.juz.responses;

import java.util.UUID;
import com.kuttaib.kuttaib_api.domain.quran.entity.Juz;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
@Builder 
public class JuzListResponse {
    private UUID id;
    private Integer number;
    private Integer totalPage;
    private Integer totalVerseCount;

    public static JuzListResponse from(Juz target) {
        return JuzListResponse.builder()
                .id(target.getId())
                .number(target.getNumber())
                .totalPage((target.getEndPage() - target.getStartPage()) + 1)
                .totalVerseCount(target.getTotalVerseCount())
                .build();
    }
}
