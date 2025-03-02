package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.Cooler;
import com.onlinepcshop.core.repository.CoolerRepository;
import com.onlinepcshop.core.repository.ProductRatingRepository;
import com.onlinepcshop.core.usecase.CoolerUseCase;
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
public class CoolerUseCaseImpl implements CoolerUseCase {
    private final CoolerRepository coolerRepository;
    private final ProductRatingRepository productRatingRepository;

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
        return coolerRepository.findAllCoolers().stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Cooler> findAllAvailableCoolers() {
        return coolerRepository.findAllAvailableCoolers().stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
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
        return coolerRepository.findAllCoolersByMaxPrice(maxPrice).stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Cooler> searchByName(String name) {
        return coolerRepository.searchByComponentName(name).stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public Double getCoolerAverageRating(UUID coolerId) {
        return productRatingRepository.findAverageRatingByProductId(coolerId);
    }
}
