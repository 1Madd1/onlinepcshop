package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.Ram;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RamRepository {
    List<Ram> findAllRams();

    Optional<Ram> findById(UUID ramId);

    Ram saveRam(Ram ram);

    void deleteRam(UUID id);

    List<Ram> findAllRamsByMaxPriceAndMemoryType(Double maxPrice, String memoryType);
}
