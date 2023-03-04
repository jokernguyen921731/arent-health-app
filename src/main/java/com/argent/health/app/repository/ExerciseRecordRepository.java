package com.argent.health.app.repository;

import com.argent.health.app.entity.ExerciseRecordEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface ExerciseRecordRepository extends JpaRepository<ExerciseRecordEntity, UUID> {
    @Query("SELECT a FROM ExerciseRecordEntity a where a.deleted=false AND a.exerciseId=:exerciseId")
    Optional<ExerciseRecordEntity> findByExerciseId(UUID exerciseId);

    @Query("SELECT a FROM ExerciseRecordEntity a where a.deleted=false")
    Page<ExerciseRecordEntity> findAllWithPaging(Pageable pageable);

    @Query("SELECT a FROM ExerciseRecordEntity a where a.deleted=false AND a.name=:name")
    Optional<ExerciseRecordEntity> findByName(String name);
}
