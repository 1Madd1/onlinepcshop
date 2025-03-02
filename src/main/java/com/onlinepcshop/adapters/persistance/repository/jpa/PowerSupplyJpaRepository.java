package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.PowerSupplyDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface PowerSupplyJpaRepository extends JpaRepository<PowerSupplyDao, UUID> {
    List<PowerSupplyDao> findAllByQuantityGreaterThan(Integer quantity);

    List<PowerSupplyDao> findByPriceLessThanEqualAndWattageGreaterThanEqualAndQuantityGreaterThan(Double maxPrice, Integer minWattage, Integer maxWattage);

    List<PowerSupplyDao> findBySaleTypeNotNullAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(String componentName, Integer quantity);

    List<PowerSupplyDao> findByComponentNameContainingIgnoreCaseAndQuantityGreaterThan(String componentName, Integer quantity);

    List<PowerSupplyDao> findByDateOfCreationAfterAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(LocalDate date, String componentName, Integer quantity);
}
