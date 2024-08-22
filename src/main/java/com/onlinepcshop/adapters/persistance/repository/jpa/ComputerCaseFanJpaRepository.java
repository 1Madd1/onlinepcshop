package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.ComputerCaseFanDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComputerCaseFanJpaRepository extends JpaRepository<ComputerCaseFanDao, UUID> {
}
