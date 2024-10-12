package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.Cooler;
import com.onlinepcshop.core.repository.CoolerRepository;
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
    private final CoolerRepository coolerRepository;

    @Override
    public Cooler createCooler(Cooler cooler) {
        return coolerRepository.saveCooler(cooler);
    }

    @Override
    public Cooler updateCooler(Cooler cooler) {
        return coolerRepository.saveCooler(cooler);
    }

    @Override
    public List<Cooler> findAllCoolers() {
        return coolerRepository.findAllCoolers();
    }

    @Override
    public Optional<Cooler> findCoolerById(UUID cpuCoolerId) {
        return coolerRepository.findById(cpuCoolerId);
    }

    @Override
    public void deleteCooler(UUID id) {
        coolerRepository.deleteCooler(id);
    }

    @Override
    public List<Cooler> findAllCoolersByMaxPrice(Double maxPrice) {
        return coolerRepository.findAllCoolersByMaxPrice(maxPrice);
    }
}
