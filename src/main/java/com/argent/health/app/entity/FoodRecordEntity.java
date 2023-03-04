package com.argent.health.app.entity;

import com.argent.health.app.enums.MealType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "food_record")
@Setter
@Getter
@Builder
@EqualsAndHashCode(callSuper = true)
public class FoodRecordEntity extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "food_id", updatable = false)
    private UUID foodId;

    @Column(name = "name")
    private String name;

    @Column(name = "meal_type")
    @Enumerated(EnumType.STRING)
    private MealType mealType;

    @Column(name = "eat_at")
    private LocalDateTime eatAt;

    @Column(name = "calorie")
    private int calorie;

    @Builder.Default
    private Boolean deleted = false;
}
