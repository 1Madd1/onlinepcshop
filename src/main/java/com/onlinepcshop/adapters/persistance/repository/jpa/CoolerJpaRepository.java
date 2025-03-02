package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.CoolerDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface CoolerJpaRepository extends JpaRepository<CoolerDao, UUID> {
    List<CoolerDao> findAllByQuantityGreaterThan(Integer quantity);

    List<CoolerDao> findByPriceLessThanEqualAndQuantityGreaterThan(Double maxPrice, Integer quantity);

    List<CoolerDao> findBySaleTypeNotNullAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(String componentName, Integer quantity);

    List<CoolerDao> findByComponentNameContainingIgnoreCaseAndQuantityGreaterThan(String componentName, Integer quantity);

    List<CoolerDao> findByDateOfCreationAfterAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(LocalDate date, String componentName, Integer quantity);
}
