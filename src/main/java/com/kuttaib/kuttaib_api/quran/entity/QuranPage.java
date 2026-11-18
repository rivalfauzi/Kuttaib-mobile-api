package com.kuttaib.kuttaib_api.quran.entity;

import com.kuttaib.kuttaib_api.commons.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "quran_pages")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuranPage extends BaseEntity {

    @Column(nullable = false, unique = true)
    private Integer pageNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "start_surah_id",
            nullable = false
    )
    private Surah startSurah;

    @Column(nullable = false)
    private Integer startAyah;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "end_surah_id",
            nullable = false
    )
    private Surah endSurah;

    @Column(nullable = false)
    private Integer endAyah;

    @Column(nullable = false)
    private Integer juzNumber;
}