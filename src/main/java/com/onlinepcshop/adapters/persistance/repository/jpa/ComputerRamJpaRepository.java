package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.ComputerRamDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComputerRamJpaRepository extends JpaRepository<ComputerRamDao, UUID> {
}
