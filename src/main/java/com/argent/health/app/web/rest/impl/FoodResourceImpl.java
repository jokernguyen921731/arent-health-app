package com.argent.health.app.web.rest.impl;

import com.argent.health.app.domain.FoodRecord;
import com.argent.health.app.web.rest.FoodResource;
import com.argent.health.app.web.rest.request.food.FoodCreateRequest;
import com.argent.health.app.web.rest.request.food.FoodUpdateRequest;
import com.argent.health.app.web.rest.response.ServiceResponse;
import com.vsm.vin.common.model.PageCriteria;
import com.vsm.vin.common.model.PageResponse;

import java.util.UUID;

public class FoodResourceImpl implements FoodResource {
    @Override
    public ServiceResponse<FoodRecord> create(FoodCreateRequest request) {
        return null;
    }

    @Override
    public ServiceResponse<FoodRecord> update(FoodUpdateRequest request, UUID foodId) {
        return null;
    }

    @Override
    public ServiceResponse<Void> delete(UUID foodId) {
        return null;
    }

    @Override
    public ServiceResponse<PageResponse<FoodRecord>> search(PageCriteria pageCriteria) {
        return null;
    }
}
