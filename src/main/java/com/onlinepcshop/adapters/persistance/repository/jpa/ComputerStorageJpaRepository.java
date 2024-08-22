package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.ComputerStorageDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComputerStorageJpaRepository extends JpaRepository<ComputerStorageDao, UUID> {
}
