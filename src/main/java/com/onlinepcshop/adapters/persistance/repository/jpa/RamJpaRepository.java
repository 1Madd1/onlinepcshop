package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.RamDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RamJpaRepository extends JpaRepository<RamDao, UUID> {
    List<RamDao> findByPriceLessThanEqualAndMemoryType(Double maxPrice, String memoryType);
}
