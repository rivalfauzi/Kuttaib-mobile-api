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
    private String target;
    private Integer totalTarget;
    private String targetType;
    private Integer targetDailyTime;
    private Integer estimation;
}
