package com.argent.health.app.web.rest.request.exercise;

import lombok.*;

import javax.validation.Valid;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Valid
public class ExerciseUpdateRequest {
    private String name;
    private String calorieReduction;
    private String timeDuration;
}
