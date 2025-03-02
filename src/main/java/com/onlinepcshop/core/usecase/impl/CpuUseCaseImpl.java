package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.Cpu;
import com.onlinepcshop.core.repository.CpuRepository;
import com.onlinepcshop.core.repository.ProductRatingRepository;
import com.onlinepcshop.core.usecase.CpuUseCase;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Builder
public class CpuUseCaseImpl implements CpuUseCase {
    private final CpuRepository cpuRepository;
    private final ProductRatingRepository productRatingRepository;

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
        return cpuRepository.findAllCpus().stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Cpu> findAllAvailableCpus() {
        return cpuRepository.findAllAvailableCpus().stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Cpu> findCpuById(UUID cpuId) {
        return cpuRepository.findById(cpuId);
    }

    @Override
    public void deleteCpu(UUID id) {
        cpuRepository.deleteCpu(id);
    }

    @Override
    public List<Cpu> findAllCpusByMaxPriceAndSocketTypeIncludesCoolerAndIntegratedGpu(Double maxPrice, String socketType, Boolean includesCooler, Boolean includesIntegratedGpu) {
        return cpuRepository.findAllCpusByMaxPriceAndSocketTypeIncludesCoolerAndIntegratedGpu(maxPrice, socketType, includesCooler, includesIntegratedGpu).stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Cpu> searchByName(String name) {
        return cpuRepository.searchByComponentName(name).stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public Double getCpuAverageRating(UUID cpuId) {
        return productRatingRepository.findAverageRatingByProductId(cpuId);
    }
}
