package com.argent.health.app.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "diary")
@Setter
@Getter
@Builder
@EqualsAndHashCode(callSuper = true)
public class DiaryEntity extends AuditEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "diary_id", updatable = false)
    private UUID diaryId;

    @Column(name="title")
    private String title;

    @Column(name="note")
    private String note;
}
