package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.CoolerDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CpuCoolerJpaRepository extends JpaRepository<CoolerDao, UUID> {
}
