package com.argent.health.app.service.mapper;

import com.argent.health.app.domain.FoodRecord;
import com.argent.health.app.entity.FoodRecordEntity;
import com.argent.health.app.util.DateUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface FoodRecordMapper extends ModelMapper<FoodRecordEntity, FoodRecord>{
}
