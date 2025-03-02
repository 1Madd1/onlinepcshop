package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.MotherboardDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface MotherboardJpaRepository extends JpaRepository<MotherboardDao, UUID> {
    List<MotherboardDao> findAllByQuantityGreaterThan(Integer quantity);

    List<MotherboardDao> findByPriceLessThanEqualAndQuantityGreaterThan(Double maxPrice, Integer quantity);

    List<MotherboardDao> findBySaleTypeNotNullAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(String componentName, Integer quantity);

    List<MotherboardDao> findByComponentNameContainingIgnoreCaseAndQuantityGreaterThan(String componentName, Integer quantity);

    List<MotherboardDao> findByDateOfCreationAfterAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(LocalDate date, String componentName, Integer quantity);
}
