package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.RamDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface RamJpaRepository extends JpaRepository<RamDao, UUID> {
    List<RamDao> findAllByQuantityGreaterThan(Integer quantity);

    List<RamDao> findByPriceLessThanEqualAndMemoryTypeAndQuantityGreaterThan(Double maxPrice, String memoryType, Integer quantity);

    List<RamDao> findBySaleTypeNotNullAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(String componentName, Integer quantity);

    List<RamDao> findByComponentNameContainingIgnoreCaseAndQuantityGreaterThan(String componentName, Integer quantity);

    List<RamDao> findByDateOfCreationAfterAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(LocalDate date, String componentName, Integer quantity);
}
