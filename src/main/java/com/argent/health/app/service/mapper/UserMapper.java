package com.argent.health.app.service.mapper;

import com.argent.health.app.domain.User;
import com.argent.health.app.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends ModelMapper<UserEntity, User>{
}
