package com.argent.health.app.web.rest;

import com.argent.health.app.domain.ExerciseRecord;
import com.argent.health.app.web.rest.request.exercise.ExerciseCreateRequest;
import com.argent.health.app.web.rest.request.exercise.ExerciseUpdateRequest;
import com.argent.health.app.web.rest.response.ServiceResponse;
import com.argent.health.app.web.rest.validator.ValidatePageCriteria;
import com.vsm.vin.common.model.PageCriteria;
import com.vsm.vin.common.model.PageResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

public interface ExerciseRecordResource {
    @ApiOperation(value = "insert the exercise record")
    @PostMapping("/create")
    ServiceResponse<ExerciseRecord> create(@RequestBody @Valid ExerciseCreateRequest request);

    @ApiOperation(value = "update the information of the exercise record")
    @PutMapping("/update/{exercise-id}")
    ServiceResponse<ExerciseRecord> update(@RequestBody @Valid ExerciseUpdateRequest request,
                                       @PathVariable("exercise-id") @Valid UUID exerciseId);

    @ApiOperation(value = "delete the food record")
    @DeleteMapping("/delete/{exercise-id}")
    ServiceResponse<Void> delete(@PathVariable("exercise-id") @Valid UUID exerciseId);

    @ApiOperation(value = "search list food record")
    @GetMapping(value = "/search")
    ServiceResponse<PageResponse<ExerciseRecord>> search(@Valid @ValidatePageCriteria(allowSorts = {"createdAt", "updatedAt", "name"})
                                                             PageCriteria pageCriteria);
}
