package com.kuttaib.kuttaib_api.feature.target.services;

import lombok.RequiredArgsConstructor;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.kuttaib.kuttaib_api.domain.quran.entity.Surah;
import com.kuttaib.kuttaib_api.domain.quran.repository.SurahRepository;
import com.kuttaib.kuttaib_api.feature.target.request.CreateOnboardingRequest;
import com.kuttaib.kuttaib_api.feature.target.response.CreateOnboardingTarget;

@Service 
@RequiredArgsConstructor 
public class TargetServices {
    private final SurahRepository surahRepository;
    
    public CreateOnboardingTarget createOnboardingTarget(
        CreateOnboardingRequest request
    ) {
        String targetName;
        String targetDescription;
        String dailyTargetString;
        String estimation;

        switch (request.getTargetType()) {
            case SURAH:
                Surah surah = surahRepository.findByNumber(request.getTargetNumber())
                        .orElseThrow(() -> new IllegalArgumentException(
                                "Surah not found with number: " + request.getTargetNumber()
                        ));

                targetName = "Surah " + surah.getLatinName();
                targetDescription = surah.getVerseCount() + " Ayat";
                dailyTargetString = request.getDailyTarget().intValue() + " Ayat per hari";

                int result = (int) Math.ceil((double) surah.getVerseCount() / request.getDailyTarget().intValue());
                estimation = result + " hari";

                break;
            case JUZ:
                targetName = "Juz " + request.getTargetNumber();
                targetDescription = "564 Ayat";
                estimation = "20 hari";

                switch (request.getDailyTargetType()) {
                    case AYAH:
                        Integer dailyTarget = request.getDailyTarget().intValue();
                        dailyTargetString = dailyTarget + " Ayat per hari";
                        break;
                    case PAGE:
                        String targetString = null;
                        if (request.getDailyTarget() == 0.25) targetString = "1/4";
                        if (request.getDailyTarget() == 0.5) targetString = "1/2";
                        if (request.getDailyTarget() == 1.0) targetString = "1";

                        dailyTargetString = targetString + " Halaman per hari";
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid daily target type: " + request.getDailyTargetType());
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid target type: " + request.getTargetType());
        }

        return CreateOnboardingTarget.builder()
                .id(UUID.randomUUID())
                .targetName(targetName)
                .targetDescription(targetDescription)
                .dailyTargetString(dailyTargetString)
                .targetDailyTime(request.getTargetTime() + " menit per hari")
                .estimation(estimation)
                .build();
    }
}
