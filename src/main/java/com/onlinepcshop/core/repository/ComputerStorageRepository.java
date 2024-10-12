package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.ComputerStorage;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ComputerStorageRepository {
    List<ComputerStorage> findAllComputerStorages();

    Optional<ComputerStorage> findById(UUID computerStorageId);

    ComputerStorage saveComputerStorage(ComputerStorage computerStorage);

    void deleteComputerStorage(UUID id);

    List<ComputerStorage> findAllByStorageAndComputer(UUID storageId, UUID computerId);

    List<ComputerStorage> findAllByComputer(UUID computerId);

    Integer findQuantityByStorageIdAndComputerId(UUID storageId, UUID computerId);
}
