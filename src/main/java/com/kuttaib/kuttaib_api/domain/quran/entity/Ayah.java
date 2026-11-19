package com.kuttaib.kuttaib_api.domain.quran.entity;

import com.kuttaib.kuttaib_api.commons.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "ayahs",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {
                                "surah_id",
                                "verse_number"
                        }
                )
        }
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ayah extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "surah_id",
            nullable = false
    )
    private Surah surah;

    @Column(nullable = false)
    private Integer verseNumber;

    @Column(columnDefinition = "TEXT")
    private String arabicText;

    @Column(columnDefinition = "TEXT")
    private String latinText;

    @Column(columnDefinition = "TEXT")
    private String indonesianText;

    @Column(columnDefinition = "TEXT")
    private String audio01;

    @Column(columnDefinition = "TEXT")
    private String audio02;

    @Column(columnDefinition = "TEXT")
    private String audio03;

    @Column(columnDefinition = "TEXT")
    private String audio04;

    @Column(columnDefinition = "TEXT")
    private String audio05;

    @Column(columnDefinition = "TEXT")
    private String audio06;
}