package com.argent.health.app.repository;

import com.argent.health.app.domain.User;
import com.argent.health.app.entity.UserEntity;
import com.argent.health.app.enums.IdentityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, User> {
    @Query("SELECT a FROM UserEntity a where a.userId=:userId AND a.deleted=false")
    Optional<UserEntity> findByUserId(UUID userId);

    @Query("select u from UserEntity  u " +
            "where lower(u.username) = lower(:username) and u.identityType = :type")
    Optional<UserEntity> findByUsernameAndIdentityProviderType(String username, IdentityType type);
}
