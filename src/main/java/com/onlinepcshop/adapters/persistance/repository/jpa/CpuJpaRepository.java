package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.CpuDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CpuJpaRepository extends JpaRepository<CpuDao, UUID> {
    List<CpuDao> findByPriceLessThanEqualAndSocketTypeAndIncludesCoolerAndIncludesIntegratedGpu(Double maxPrice, String socketType, Boolean includesCooler, Boolean includesIntegratedGpu);
}
