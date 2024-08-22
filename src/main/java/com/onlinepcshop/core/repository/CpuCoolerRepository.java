package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.Cooler;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CpuCoolerRepository {
    List<Cooler> findAllCpuCoolers();

    Optional<Cooler> findById(UUID cpuCoolerId);

    Cooler saveCpuCooler(Cooler cooler);

    void deleteCpuCooler(UUID id);
}
