package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.PowerSupply;
import com.onlinepcshop.core.repository.PowerSupplyRepository;
import com.onlinepcshop.core.repository.ProductRatingRepository;
import com.onlinepcshop.core.usecase.PowerSupplyUseCase;
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
public class PowerSupplyUseCaseImpl implements PowerSupplyUseCase {
    private final PowerSupplyRepository powerSupplyRepository;
    private final ProductRatingRepository productRatingRepository;

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
        return powerSupplyRepository.findAllPowerSupplys().stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public List<PowerSupply> findAllAvailablePowerSupplys() {
        return powerSupplyRepository.findAllAvailablePowerSupplys().stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
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
        return powerSupplyRepository.findAllPowerSupplysByMaxPriceAndMinWattage(maxPrice, minWattage).stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public List<PowerSupply> searchByName(String name) {
        return powerSupplyRepository.searchByComponentName(name).stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public Double getPowerSupplyAverageRating(UUID powerSupplyId) {
        return productRatingRepository.findAverageRatingByProductId(powerSupplyId);
    }
}
