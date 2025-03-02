package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.CpuDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface CpuJpaRepository extends JpaRepository<CpuDao, UUID> {
    List<CpuDao> findAllByQuantityGreaterThan(Integer quantity);

    List<CpuDao> findByPriceLessThanEqualAndSocketTypeAndIncludesCoolerAndIncludesIntegratedGpuAndQuantityGreaterThan(Double maxPrice, String socketType, Boolean includesCooler, Boolean includesIntegratedGpu, Integer quantity);

    List<CpuDao> findBySaleTypeNotNullAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(String componentName, Integer quantity);

    List<CpuDao> findByComponentNameContainingIgnoreCaseAndQuantityGreaterThan(String componentName, Integer quantity);

    List<CpuDao> findByDateOfCreationAfterAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(LocalDate date, String componentName, Integer quantity);
}
