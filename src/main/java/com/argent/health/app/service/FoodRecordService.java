package com.argent.health.app.service;

import com.argent.health.app.domain.FoodRecord;
import com.argent.health.app.web.rest.request.food.FoodCreateRequest;
import com.argent.health.app.web.rest.request.food.FoodUpdateRequest;
import com.vsm.vin.common.model.PageCriteria;
import com.vsm.vin.common.model.PageResponse;

import java.util.UUID;

public interface FoodRecordService {
    FoodRecord create(FoodCreateRequest request);
    FoodRecord update(FoodUpdateRequest request, UUID foodId);
    Void delete(UUID foodId);
    PageResponse<FoodRecord> search(PageCriteria pageCriteria);
}
