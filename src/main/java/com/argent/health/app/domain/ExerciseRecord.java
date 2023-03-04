package com.argent.health.app.domain;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ExerciseRecord {
    private UUID id;
    private String name;
    private String calorieReduction;
    private String timeDuration;
}
