package com.argent.health.app.service.impl;

import com.argent.health.app.domain.FoodRecord;
import com.argent.health.app.entity.FoodRecordEntity;
import com.argent.health.app.service.mapper.FoodRecordMapper;
import com.argent.health.app.exception.http.InvalidInputError;
import com.argent.health.app.exception.http.NotFoundError;
import com.argent.health.app.repository.FoodRecordRepository;
import com.argent.health.app.service.FoodRecordService;
import com.argent.health.app.web.rest.request.food.FoodCreateRequest;
import com.argent.health.app.web.rest.request.food.FoodUpdateRequest;
import com.vsm.vin.common.misc.exception.http.ResponseException;
import com.vsm.vin.common.model.PageCriteria;
import com.vsm.vin.common.model.PageResponse;
import com.vsm.vin.common.persistence.entity.PageCriteriaPageableMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
@Slf4j
public class FoodRecordServiceImpl implements FoodRecordService {
    private final FoodRecordRepository foodRecordRepository;
    private final FoodRecordMapper foodRecordMapper;
    private final PageCriteriaPageableMapper pageCriteriaPageableMapper;

    public FoodRecordServiceImpl(FoodRecordRepository foodRecordRepository,
                                 FoodRecordMapper foodRecordMapper,
                                 PageCriteriaPageableMapper pageCriteriaPageableMapper) {
        this.foodRecordRepository = foodRecordRepository;
        this.foodRecordMapper = foodRecordMapper;
        this.pageCriteriaPageableMapper = pageCriteriaPageableMapper;
    }

    @Override
    @Transactional
    public FoodRecord create(FoodCreateRequest request) {
        Optional<FoodRecordEntity> existFoodRecord = foodRecordRepository.findByName(request.getFoodName());
        if (existFoodRecord.isPresent()) {
            throw new ResponseException(InvalidInputError.FOOD_RECORD_EXIST.getMessage(), InvalidInputError.FOOD_RECORD_EXIST);
        }
        var foodRecordEntity = FoodRecordEntity.builder()
                .name(request.getFoodName())
                .mealType(request.getMealType())
                .eatAt(request.getEatAt())
                .calorie(request.getCalorie())
                .build();
        foodRecordRepository.save(foodRecordEntity);
        return foodRecordMapper.toTarget(foodRecordEntity);
    }

    @Override
    @Transactional
    public FoodRecord update(FoodUpdateRequest request, UUID foodId) {
        var foodRecordEntity = this.findByFoodRecordId(foodId);
        if (Objects.nonNull(request.getFoodName())) {
            foodRecordEntity.setName(request.getFoodName());
        }
        if (Objects.nonNull(request.getMealType())) {
            foodRecordEntity.setMealType(request.getMealType());
        }
        if (Objects.nonNull(request.getEatAt())) {
            foodRecordEntity.setEatAt(request.getEatAt());
        }
        if (Objects.nonNull(request.getCalorie())) {
            foodRecordEntity.setCalorie(request.getCalorie());
        }
        foodRecordRepository.save(foodRecordEntity);
        return foodRecordMapper.toTarget(foodRecordEntity);
    }

    @Override
    @Transactional
    public Void delete(UUID foodId) {
        var foodRecordEntity = this.findByFoodRecordId(foodId);
        foodRecordEntity.setDeleted(true);
        foodRecordRepository.save(foodRecordEntity);
        return null;
    }

    @Override
    public PageResponse<FoodRecord> search(PageCriteria pageCriteria) {
        if (CollectionUtils.isEmpty(pageCriteria.getSort())) {
            pageCriteria.setSort(Collections.singletonList((
                    "-updatedAt"
            )));
        }
        var pageFoodRecord = foodRecordRepository.findAllWithPaging(pageCriteriaPageableMapper
                .toPageable(pageCriteria));
        var foodRecordEntities = foodRecordMapper.toTarget(pageFoodRecord.getContent());
        return PageResponse.<FoodRecord>builder()
                .count(pageFoodRecord.getTotalElements())
                .rows(foodRecordEntities)
                .page(pageCriteria.getPage())
                .limit(pageCriteria.getLimit())
                .build();
    }

    public FoodRecordEntity findByFoodRecordId(UUID id) {
        Optional<FoodRecordEntity> existFoodRecord = foodRecordRepository.findByFoodRecordId(id);
        if (existFoodRecord.isEmpty()) {
            throw new ResponseException(NotFoundError.FOOD_RECORD_NOT_FOUND.getMessage(), NotFoundError.FOOD_RECORD_NOT_FOUND);
        }
        return existFoodRecord.get();
    }
}
