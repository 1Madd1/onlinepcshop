package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.ComputerRamDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ComputerRamJpaRepository extends JpaRepository<ComputerRamDao, UUID> {
    List<ComputerRamDao> findAllByRamIdAndComputerId(UUID ramId, UUID computerId);

    List<ComputerRamDao> findAllByComputerId(UUID computerId);

    Optional<ComputerRamDao> findByRamIdAndComputerId(UUID ramId, UUID computerId);
}
