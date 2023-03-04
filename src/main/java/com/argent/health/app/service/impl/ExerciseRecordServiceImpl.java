package com.argent.health.app.service.impl;

import com.argent.health.app.domain.ExerciseRecord;
import com.argent.health.app.entity.ExerciseRecordEntity;
import com.argent.health.app.exception.http.InvalidInputError;
import com.argent.health.app.exception.http.NotFoundError;
import com.argent.health.app.repository.ExerciseRecordRepository;
import com.argent.health.app.service.ExerciseRecordService;
import com.argent.health.app.service.mapper.ExerciseRecordMapper;
import com.argent.health.app.web.rest.request.exercise.ExerciseCreateRequest;
import com.argent.health.app.web.rest.request.exercise.ExerciseUpdateRequest;
import com.vsm.vin.common.misc.exception.http.ResponseException;
import com.vsm.vin.common.model.PageCriteria;
import com.vsm.vin.common.model.PageResponse;
import com.vsm.vin.common.persistence.entity.PageCriteriaPageableMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class ExerciseRecordServiceImpl implements ExerciseRecordService {
    private final ExerciseRecordRepository exerciseRecordRepository;
    private final ExerciseRecordMapper exerciseRecordMapper;
    private final PageCriteriaPageableMapper pageCriteriaPageableMapper;

    public ExerciseRecordServiceImpl(ExerciseRecordRepository exerciseRecordRepository,
                                     ExerciseRecordMapper exerciseRecordMapper,
                                     PageCriteriaPageableMapper pageCriteriaPageableMapper) {
        this.exerciseRecordRepository = exerciseRecordRepository;
        this.exerciseRecordMapper = exerciseRecordMapper;
        this.pageCriteriaPageableMapper = pageCriteriaPageableMapper;
    }

    @Override
    public ExerciseRecord create(ExerciseCreateRequest request) {
        Optional<ExerciseRecordEntity> existExerciseRecord = exerciseRecordRepository.findByName(request.getName());
        if (existExerciseRecord.isPresent()) {
            throw new ResponseException(InvalidInputError.EXERCISE_RECORD_EXIST.getMessage(), InvalidInputError.EXERCISE_RECORD_EXIST);
        }
        var exerciseRecordEntity = ExerciseRecordEntity.builder()
                .name(request.getName())
                .calorieReduction(request.getCalorieReduction())
                .timeDuration(request.getTimeDuration()).build();
        exerciseRecordRepository.save(exerciseRecordEntity);
        return exerciseRecordMapper.toTarget(exerciseRecordEntity);
    }

    @Override
    public ExerciseRecord update(ExerciseUpdateRequest request, UUID exerciseId) {
        var exerciseRecordEntity = this.findByExerciseRecordId(exerciseId);
        if (Objects.nonNull(request.getName())) {
            exerciseRecordEntity.setName(request.getName());
        }
        if (Objects.nonNull(request.getCalorieReduction())) {
            exerciseRecordEntity.setCalorieReduction(request.getCalorieReduction());
        }
        if (Objects.nonNull(request.getTimeDuration())) {
            exerciseRecordEntity.setTimeDuration(request.getTimeDuration());
        }
        exerciseRecordRepository.save(exerciseRecordEntity);
        return exerciseRecordMapper.toTarget(exerciseRecordEntity);
    }

    @Override
    public Void delete(UUID exerciseId) {
        var exerciseRecordEntity = this.findByExerciseRecordId(exerciseId);
        exerciseRecordEntity.setDeleted(true);
        exerciseRecordRepository.save(exerciseRecordEntity);
        return null;
    }

    @Override
    public PageResponse<ExerciseRecord> search(PageCriteria pageCriteria) {
        if (CollectionUtils.isEmpty(pageCriteria.getSort())) {
            pageCriteria.setSort(Collections.singletonList((
                    "-updatedAt"
            )));
        }
        var pageExerciseRecord = exerciseRecordRepository.findAllWithPaging(pageCriteriaPageableMapper
                .toPageable(pageCriteria));
        var exerciseRecordEntity = exerciseRecordMapper.toTarget(pageExerciseRecord.getContent());
        return PageResponse.<ExerciseRecord>builder()
                .count(pageExerciseRecord.getTotalElements())
                .rows(exerciseRecordEntity)
                .page(pageCriteria.getPage())
                .limit(pageCriteria.getLimit())
                .build();
    }

    public ExerciseRecordEntity findByExerciseRecordId(UUID id) {
        Optional<ExerciseRecordEntity> existExerciseRecord = exerciseRecordRepository.findByExerciseId(id);
        if (existExerciseRecord.isEmpty()) {
            throw new ResponseException(NotFoundError.EXERCISE_RECORD_NOT_FOUND.getMessage(), NotFoundError.EXERCISE_RECORD_NOT_FOUND);
        }
        return existExerciseRecord.get();
    }
}
