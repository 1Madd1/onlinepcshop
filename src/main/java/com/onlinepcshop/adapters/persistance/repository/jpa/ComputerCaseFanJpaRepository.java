package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.ComputerCaseFanDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ComputerCaseFanJpaRepository extends JpaRepository<ComputerCaseFanDao, UUID> {
    List<ComputerCaseFanDao> findAllByCaseFanIdAndComputerId(UUID caseFanId, UUID computerId);

    List<ComputerCaseFanDao> findAllByComputerId(UUID computerId);

    Optional<ComputerCaseFanDao> findByCaseFanIdAndComputerId(UUID caseFanId, UUID computerId);
}
