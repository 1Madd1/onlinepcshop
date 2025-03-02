package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.CaseFanDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface CaseFanJpaRepository extends JpaRepository<CaseFanDao, UUID> {
    List<CaseFanDao> findAllByQuantityGreaterThan(Integer quantity);

    List<CaseFanDao> findByPriceLessThanEqualAndQuantityGreaterThan(Double maxPrice, Integer quantity);

    List<CaseFanDao> findByComponentNameContainingIgnoreCaseAndQuantityGreaterThan(String componentName, Integer quantity);

    List<CaseFanDao> findBySaleTypeNotNullAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(String componentName, Integer quantity);

    List<CaseFanDao> findByDateOfCreationAfterAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(LocalDate date, String componentName, Integer quantity);
}
