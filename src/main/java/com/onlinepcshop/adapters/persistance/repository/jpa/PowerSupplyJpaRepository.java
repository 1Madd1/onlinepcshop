package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.PowerSupplyDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PowerSupplyJpaRepository extends JpaRepository<PowerSupplyDao, UUID> {
}
