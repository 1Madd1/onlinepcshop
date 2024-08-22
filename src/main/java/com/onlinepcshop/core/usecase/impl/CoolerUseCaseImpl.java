package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.Cooler;
import com.onlinepcshop.core.repository.CpuCoolerRepository;
import com.onlinepcshop.core.usecase.CoolerUseCase;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Builder
public class CoolerUseCaseImpl implements CoolerUseCase {
    private final CpuCoolerRepository cpuCoolerRepository;

    @Override
    public Cooler createCpuCooler(Cooler cooler) {
        return cpuCoolerRepository.saveCpuCooler(cooler);
    }

    @Override
    public Cooler updateCpuCooler(Cooler cooler) {
        return cpuCoolerRepository.saveCpuCooler(cooler);
    }

    @Override
    public List<Cooler> findAllCpuCoolers() {
        return cpuCoolerRepository.findAllCpuCoolers();
    }

    @Override
    public Optional<Cooler> findCpuCoolerById(UUID cpuCoolerId) {
        return cpuCoolerRepository.findById(cpuCoolerId);
    }

    @Override
    public void deleteCpuCooler(UUID id) {
        cpuCoolerRepository.deleteCpuCooler(id);
    }
}
