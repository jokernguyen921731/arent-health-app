package com.argent.health.app.domain;

import com.argent.health.app.enums.MealType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class FoodRecord {
    private UUID foodId;
    private String name;
    private MealType mealType;
    private LocalDateTime eatAt;
    private int calorie;
}
