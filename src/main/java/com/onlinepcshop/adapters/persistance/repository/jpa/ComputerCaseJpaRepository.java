package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.ComputerCaseDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComputerCaseJpaRepository extends JpaRepository<ComputerCaseDao, UUID> {
}
