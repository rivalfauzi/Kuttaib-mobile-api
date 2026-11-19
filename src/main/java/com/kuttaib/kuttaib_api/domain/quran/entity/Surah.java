package com.kuttaib.kuttaib_api.domain.quran.entity;

import com.kuttaib.kuttaib_api.commons.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "surahs")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Surah extends BaseEntity {

    @Column(nullable = false, unique = true)
    private Integer number;

    @Column(nullable = false)
    private String arabicName;

    @Column(nullable = false)
    private String latinName;

    @Column(nullable = false)
    private String meaning;

    @Column(nullable = false)
    private String revelationPlace;

    @Column(nullable = false)
    private Integer verseCount;

    @Column(columnDefinition = "TEXT")
    private String description;
}
