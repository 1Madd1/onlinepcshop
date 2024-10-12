package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.MotherboardDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MotherboardJpaRepository extends JpaRepository<MotherboardDao, UUID> {
    List<MotherboardDao> findByPriceLessThanEqual(Double maxPrice);
}
