package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.Cpu;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CpuRepository {
    List<Cpu> findAllCpus();

    List<Cpu> findAllAvailableCpus();

    Optional<Cpu> findById(UUID cpuId);

    Cpu saveCpu(Cpu cpu);

    void deleteCpu(UUID id);

    List<Cpu> findAllCpusByMaxPriceAndSocketTypeIncludesCoolerAndIntegratedGpu(Double maxPrice, String socketType, Boolean includesCooler, Boolean includesIntegratedGpu);

    List<Cpu> findAllByHavingSaleAndByComponentName(String componentName);

    List<Cpu> searchByComponentName(String componentName);

    List<Cpu> findAllNewCpusByComponentName(String componentName);
}
