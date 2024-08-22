package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.CpuDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CpuJpaRepository extends JpaRepository<CpuDao, UUID> {
}
