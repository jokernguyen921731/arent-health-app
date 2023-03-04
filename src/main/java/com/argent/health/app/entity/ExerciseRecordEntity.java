package com.argent.health.app.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "exercise_record")
@Setter
@Getter
@Builder
@EqualsAndHashCode(callSuper = true)
public class ExerciseRecordEntity extends AuditEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "exercise_id", updatable = false)
    private UUID exerciseId;

    @Column(name="name")
    private String name;

    @Column(name="calorie_reduction")
    private String calorieReduction;

    @Column(name="time_duration")
    private String timeDuration;

    @Builder.Default
    private Boolean deleted = false;
}
