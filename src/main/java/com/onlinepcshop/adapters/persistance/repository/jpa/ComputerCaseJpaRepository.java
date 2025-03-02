package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.ComputerCaseDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ComputerCaseJpaRepository extends JpaRepository<ComputerCaseDao, UUID> {
    List<ComputerCaseDao> findAllByQuantityGreaterThan(Integer quantity);

    List<ComputerCaseDao> findByPriceLessThanEqualAndQuantityGreaterThan(Double maxPrice, Integer quantity);

    List<ComputerCaseDao> findBySaleTypeNotNullAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(String componentName, Integer quantity);

    List<ComputerCaseDao> findByComponentNameContainingIgnoreCaseAndQuantityGreaterThan(String componentName, Integer quantity);

    List<ComputerCaseDao> findByDateOfCreationAfterAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(LocalDate date, String componentName, Integer quantity);
}
