package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.GpuDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GpuJpaRepository extends JpaRepository<GpuDao, UUID> {
    List<GpuDao> findByPriceLessThanEqualAndPcieType(Double maxPrice, String pcieType);
}
