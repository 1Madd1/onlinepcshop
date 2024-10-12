package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.CoolerDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CoolerJpaRepository extends JpaRepository<CoolerDao, UUID> {
    List<CoolerDao> findByPriceLessThanEqual(Double maxPrice);
}
