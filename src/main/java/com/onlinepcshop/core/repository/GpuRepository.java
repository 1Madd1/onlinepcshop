package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.Gpu;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GpuRepository {
    List<Gpu> findAllGpus();

    Optional<Gpu> findById(UUID gpuId);

    Gpu saveGpu(Gpu gpu);

    void deleteGpu(UUID id);
}
