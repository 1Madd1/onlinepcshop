package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.PowerSupply;
import com.onlinepcshop.core.repository.PowerSupplyRepository;
import com.onlinepcshop.core.usecase.PowerSupplyUseCase;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Builder
public class PowerSupplyUseCaseImpl implements PowerSupplyUseCase {
    private final PowerSupplyRepository powerSupplyRepository;

    @Override
    public PowerSupply createPowerSupply(PowerSupply powerSupply) {
        return powerSupplyRepository.savePowerSupply(powerSupply);
    }

    @Override
    public PowerSupply updatePowerSupply(PowerSupply powerSupply) {
        return powerSupplyRepository.savePowerSupply(powerSupply);
    }

    @Override
    public List<PowerSupply> findAllPowerSupplys() {
        return powerSupplyRepository.findAllPowerSupplys();
    }

    @Override
    public Optional<PowerSupply> findPowerSupplyById(UUID powerSupplyId) {
        return powerSupplyRepository.findById(powerSupplyId);
    }

    @Override
    public void deletePowerSupply(UUID id) {
        powerSupplyRepository.deletePowerSupply(id);
    }

    @Override
    public List<PowerSupply> findAllPowerSupplysByMaxPriceAndMinWattage(Double maxPrice, Integer minWattage) {
        return powerSupplyRepository.findAllPowerSupplysByMaxPriceAndMinWattage(maxPrice, minWattage);
    }
}
