package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.Cpu;
import com.onlinepcshop.core.repository.CpuRepository;
import com.onlinepcshop.core.usecase.CpuUseCase;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Builder
public class CpuUseCaseImpl implements CpuUseCase {
    private final CpuRepository cpuRepository;

    @Override
    public Cpu createCpu(Cpu cpu) {
        return cpuRepository.saveCpu(cpu);
    }

    @Override
    public Cpu updateCpu(Cpu cpu) {
        return cpuRepository.saveCpu(cpu);
    }

    @Override
    public List<Cpu> findAllCpus() {
        return cpuRepository.findAllCpus();
    }

    @Override
    public Optional<Cpu> findCpuById(UUID cpuId) {
        return cpuRepository.findById(cpuId);
    }

    @Override
    public void deleteCpu(UUID id) {
        cpuRepository.deleteCpu(id);
    }
}
