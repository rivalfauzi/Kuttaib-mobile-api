package com.kuttaib.kuttaib_api.domain.task.entity;

import com.kuttaib.kuttaib_api.commons.entity.BaseEntity;
import com.kuttaib.kuttaib_api.domain.target.entity.Target;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus status;

    @Column(nullable = false)
    private Integer surahNumber;

    @Column(nullable = false)
    private String surahName;

    @Column(nullable = false)
    private Integer startAyah;

    @Column(nullable = false)
    private Integer endAyah;

    /**
     * Ayat terakhir yang berhasil diselesaikan.
     *
     * contoh:
     * task = ayat 1-5
     * completedEndAyah = 3
     *
     * artinya progress 3/5.
     */
    private Integer completedEndAyah;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskType type;

    @Column(nullable = false)
    private LocalDate taskDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "target_id",
            nullable = false
    )
    private Target target;

    @Builder.Default
    @Column(nullable = false)
    private Boolean shouldDisplayOnDashboard = true;
}