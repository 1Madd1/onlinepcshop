package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.Ram;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RamRepository {
    List<Ram> findAllRams();

    List<Ram> findAllAvailableRams();

    Optional<Ram> findById(UUID ramId);

    Ram saveRam(Ram ram);

    void deleteRam(UUID id);

    List<Ram> findAllRamsByMaxPriceAndMemoryType(Double maxPrice, String memoryType);

    List<Ram> findAllByHavingSaleAndByComponentName(String componentName);

    List<Ram> searchByComponentName(String componentName);

    List<Ram> findAllNewRamsByComponentName(String componentName);
}
