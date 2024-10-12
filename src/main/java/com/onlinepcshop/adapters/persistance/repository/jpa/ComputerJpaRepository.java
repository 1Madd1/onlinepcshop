package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.ComputerDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComputerJpaRepository extends JpaRepository<ComputerDao, UUID> {
}
