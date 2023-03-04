package com.argent.health.app.domain;

import com.argent.health.app.enums.RecommendType;

import java.util.List;
import java.util.UUID;

public class Recommend {
    private UUID recommendId;
    private RecommendType recommendType;
    private String description;
    private List<Tag> tagEntities;
}
