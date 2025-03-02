package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.Gpu;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GpuRepository {
    List<Gpu> findAllGpus();

    List<Gpu> findAllAvailableGpus();

    Optional<Gpu> findById(UUID gpuId);

    Gpu saveGpu(Gpu gpu);

    void deleteGpu(UUID id);

    List<Gpu> findAllGpusByMaxPriceAndPcieInterface(Double maxPrice, String pcieType);

    List<Gpu> findAllByHavingSaleAndByComponentName(String componentName);

    List<Gpu> searchByComponentName(String componentName);

    List<Gpu> findAllNewGpusByComponentName(String componentName);
}
