package com.argent.health.app.entity;

import com.argent.health.app.enums.RecommendType;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "recommend")
@Setter
@Getter
@Builder
@EqualsAndHashCode(callSuper = true)
public class RecommendEntity extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recommend_id", updatable = false)
    private UUID recommendId;

    @Column(name = "recommend_type")
    @Enumerated(EnumType.STRING)
    private RecommendType recommendType;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "recommendEntity", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<TagEntity> tagEntities;
}
