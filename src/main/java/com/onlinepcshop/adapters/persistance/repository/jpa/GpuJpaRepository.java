package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.GpuDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface GpuJpaRepository extends JpaRepository<GpuDao, UUID> {
    List<GpuDao> findAllByQuantityGreaterThan(Integer quantity);

    List<GpuDao> findByPriceLessThanEqualAndPcieTypeAndQuantityGreaterThan(Double maxPrice, String pcieType, Integer quantity);

    List<GpuDao> findBySaleTypeNotNullAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(String componentName, Integer quantity);

    List<GpuDao> findByComponentNameContainingIgnoreCaseAndQuantityGreaterThan(String componentName, Integer quantity);

    List<GpuDao> findByDateOfCreationAfterAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(LocalDate date, String componentName, Integer quantity);
}
