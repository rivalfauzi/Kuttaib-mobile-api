package com.kuttaib.kuttaib_api.feature.target.response;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter 
@Setter 
@Builder
public class CreateOnboardingTarget {
    private UUID id;
    private String targetName;
    private String targetDescription;
    private String dailyTargetString;
    private String targetDailyTime;
    private String estimation;
}
