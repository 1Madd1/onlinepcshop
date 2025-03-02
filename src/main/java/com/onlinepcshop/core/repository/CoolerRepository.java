package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.Cooler;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CoolerRepository {
    List<Cooler> findAllCoolers();

    List<Cooler> findAllAvailableCoolers();

    Optional<Cooler> findById(UUID cpuCoolerId);

    Cooler saveCooler(Cooler cooler);

    void deleteCooler(UUID id);

    List<Cooler> findAllCoolersByMaxPrice(Double maxPrice);

    List<Cooler> findAllByHavingSaleAndByComponentName(String componentName);

    List<Cooler> searchByComponentName(String componentName);

    List<Cooler> findAllNewCoolersByComponentName(String componentName);
}
