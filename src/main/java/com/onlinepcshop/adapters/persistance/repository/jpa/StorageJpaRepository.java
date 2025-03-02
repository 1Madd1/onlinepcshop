package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.StorageDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface StorageJpaRepository extends JpaRepository<StorageDao, UUID> {
    List<StorageDao> findAllByQuantityGreaterThan(Integer quantity);

    List<StorageDao> findByPriceLessThanEqualAndStorageTypeAndQuantityGreaterThan(Double maxPrice, String storageType, Integer quantity);

    List<StorageDao> findBySaleTypeNotNullAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(String componentName, Integer quantity);

    List<StorageDao> findByComponentNameContainingIgnoreCaseAndQuantityGreaterThan(String componentName, Integer quantity);

    List<StorageDao> findByDateOfCreationAfterAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(LocalDate date, String componentName, Integer quantity);
}
