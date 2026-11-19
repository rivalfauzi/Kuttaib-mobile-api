package com.kuttaib.kuttaib_api.domain.target.entity;

import com.kuttaib.kuttaib_api.commons.entity.BaseEntity;
import com.kuttaib.kuttaib_api.domain.quran.entity.Juz;
import com.kuttaib.kuttaib_api.domain.quran.entity.Surah;
import com.kuttaib.kuttaib_api.domain.users.entity.User;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "targets")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Target extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "user_id",
        nullable = false
    )
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TargetStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TargetType targetType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "surah_id")
    private Surah surah;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "juz_id")
    private Juz juz;

    @Column(nullable = false)
    private Integer totalVerseCount;

    @Column(nullable = false)
    private Integer completedVerseCount;
}