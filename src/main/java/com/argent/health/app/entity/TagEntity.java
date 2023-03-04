package com.argent.health.app.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tag")
@Setter
@Getter
@Builder
@EqualsAndHashCode(callSuper = true)
public class TagEntity extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tag_id", nullable=false)
    private UUID tagId;

    @Column(name = "name")
    private String name;

    @ManyToOne(optional=false)
    @JoinColumn(name = "tag_id", insertable=false, updatable=false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private RecommendEntity recommendEntity;
}
