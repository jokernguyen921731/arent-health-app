package com.argent.health.app.web.rest;

import com.argent.health.app.domain.FoodRecord;
import com.argent.health.app.web.rest.request.food.FoodCreateRequest;
import com.argent.health.app.web.rest.request.food.FoodUpdateRequest;
import com.argent.health.app.web.rest.response.ServiceResponse;
import com.argent.health.app.web.rest.validator.ValidatePageCriteria;
import com.vsm.vin.common.model.PageCriteria;
import com.vsm.vin.common.model.PageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Api(tags = "Food REST Resource")
@RequestMapping("/food")
@Validated
public interface FoodResource {
    @ApiOperation(value = "insert the food record")
    @PostMapping("/create")
    ServiceResponse<FoodRecord> create(@RequestBody @Valid FoodCreateRequest request);

    @ApiOperation(value = "update the information of the food record")
    @PutMapping("/update/{food-id}")
    ServiceResponse<FoodRecord> update(@RequestBody @Valid FoodUpdateRequest request,
                                       @PathVariable("food-id") @Valid UUID foodId);

    @ApiOperation(value = "delete the food record")
    @DeleteMapping("/delete/{food-id}")
    ServiceResponse<Void> delete(@PathVariable("food-id") @Valid UUID foodId);

    @ApiOperation(value = "search list food record")
    @GetMapping(value = "/search")
    ServiceResponse<PageResponse<FoodRecord>> search(@Valid @ValidatePageCriteria(allowSorts = {"createdAt", "updatedAt", "name"})
                                                                                               PageCriteria pageCriteria);
}
