package com.kuttaib.kuttaib_api.domain.quran.entity;

import com.kuttaib.kuttaib_api.commons.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "juzs")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Juz extends BaseEntity {

    @Column(nullable = false, unique = true)
    private Integer number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "start_surah_id",
            nullable = false
    )
    private Surah startSurah;

    @Column(nullable = false)
    private Integer startAyahNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "end_surah_id",
            nullable = false
    )
    private Surah endSurah;

    @Column(nullable = false)
    private Integer endAyahNumber;

    @Column(nullable = false)
    private Integer startPage;

    @Column(nullable = false)
    private Integer endPage;

    @Column(nullable = false)
    private Integer totalVerseCount;
}