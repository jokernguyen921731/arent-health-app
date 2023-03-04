package com.argent.health.app.web.rest.impl;

import com.argent.health.app.domain.ExerciseRecord;
import com.argent.health.app.service.ExerciseRecordService;
import com.argent.health.app.web.rest.ExerciseRecordResource;
import com.argent.health.app.web.rest.request.exercise.ExerciseCreateRequest;
import com.argent.health.app.web.rest.request.exercise.ExerciseUpdateRequest;
import com.argent.health.app.web.rest.response.ServiceResponse;
import com.vsm.vin.common.model.PageCriteria;
import com.vsm.vin.common.model.PageResponse;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public class ExerciseRecordResourceImpl implements ExerciseRecordResource {
    private final ExerciseRecordService exerciseRecordService;

    public ExerciseRecordResourceImpl(ExerciseRecordService exerciseRecordService) {
        this.exerciseRecordService = exerciseRecordService;
    }

    @Override
    public ServiceResponse<ExerciseRecord> create(ExerciseCreateRequest request) {
        return ServiceResponse.succeed(HttpStatus.OK, exerciseRecordService.create(request));
    }

    @Override
    public ServiceResponse<ExerciseRecord> update(ExerciseUpdateRequest request, UUID exerciseId) {
        return ServiceResponse.succeed(HttpStatus.OK, exerciseRecordService.update(request, exerciseId));
    }

    @Override
    public ServiceResponse<Void> delete(UUID exerciseId) {
        return ServiceResponse.succeed(HttpStatus.OK, exerciseRecordService.delete(exerciseId));
    }

    @Override
    public ServiceResponse<PageResponse<ExerciseRecord>> search(PageCriteria pageCriteria) {
        return ServiceResponse.succeed(HttpStatus.OK, exerciseRecordService.search(pageCriteria));
    }
}
