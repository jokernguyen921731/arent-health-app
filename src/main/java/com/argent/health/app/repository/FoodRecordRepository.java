package com.argent.health.app.repository;

import com.argent.health.app.entity.FoodRecordEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FoodRecordRepository extends JpaRepository<FoodRecordEntity, UUID> {
    @Query("SELECT a FROM FoodRecordEntity a where a.deleted=false AND a.foodId=:foodId")
    Optional<FoodRecordEntity> findByFoodRecordId(UUID foodId);

    @Query("SELECT a FROM FoodRecordEntity a where a.deleted=false")
    Page<FoodRecordEntity> findAllWithPaging(Pageable pageable);

    @Query("SELECT a FROM FoodRecordEntity a where a.deleted=false AND a.name=:name")
    Optional<FoodRecordEntity> findByName(String name);
}
