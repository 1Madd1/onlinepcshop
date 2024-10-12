package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.ComputerStorageDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ComputerStorageJpaRepository extends JpaRepository<ComputerStorageDao, UUID> {
    List<ComputerStorageDao> findAllByStorageIdAndComputerId(UUID storageId, UUID computerId);

    List<ComputerStorageDao> findAllByComputerId(UUID computerId);

    Optional<ComputerStorageDao> findByStorageIdAndComputerId(UUID storageId, UUID computerId);
}
