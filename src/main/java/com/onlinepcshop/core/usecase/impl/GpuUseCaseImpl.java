package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.Gpu;
import com.onlinepcshop.core.repository.GpuRepository;
import com.onlinepcshop.core.usecase.GpuUseCase;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Builder
public class GpuUseCaseImpl implements GpuUseCase {
    private final GpuRepository gpuRepository;

    @Override
    public Gpu createGpu(Gpu gpu) {
        return gpuRepository.saveGpu(gpu);
    }

    @Override
    public Gpu updateGpu(Gpu gpu) {
        return gpuRepository.saveGpu(gpu);
    }

    @Override
    public List<Gpu> findAllGpus() {
        return gpuRepository.findAllGpus();
    }

    @Override
    public Optional<Gpu> findGpuById(UUID gpuId) {
        return gpuRepository.findById(gpuId);
    }

    @Override
    public void deleteGpu(UUID id) {
        gpuRepository.deleteGpu(id);
    }
}
