package com.argent.health.app.service.mapper;

import com.argent.health.app.domain.ExerciseRecord;
import com.argent.health.app.entity.ExerciseRecordEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExerciseRecordMapper extends ModelMapper<ExerciseRecordEntity, ExerciseRecord>{
}
