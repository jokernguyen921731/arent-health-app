package com.argent.health.app.service;

import com.argent.health.app.domain.ExerciseRecord;
import com.argent.health.app.web.rest.request.exercise.ExerciseCreateRequest;
import com.argent.health.app.web.rest.request.exercise.ExerciseUpdateRequest;
import com.vsm.vin.common.model.PageCriteria;
import com.vsm.vin.common.model.PageResponse;

import java.util.UUID;

public interface ExerciseRecordService {
    ExerciseRecord create(ExerciseCreateRequest request);
    ExerciseRecord update(ExerciseUpdateRequest request, UUID exerciseId);
    Void delete(UUID exerciseId);
    PageResponse<ExerciseRecord> search(PageCriteria pageCriteria);
}
