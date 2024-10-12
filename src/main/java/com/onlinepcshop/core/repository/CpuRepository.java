package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.ComputerCase;
import com.onlinepcshop.core.domain.entity.Cpu;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CpuRepository {
    List<Cpu> findAllCpus();

    Optional<Cpu> findById(UUID cpuId);

    Cpu saveCpu(Cpu cpu);

    void deleteCpu(UUID id);

    List<Cpu> findAllCpusByMaxPriceAndSocketTypeIncludesCoolerAndIntegratedGpu(Double maxPrice, String socketType, Boolean includesCooler, Boolean includesIntegratedGpu);
}
