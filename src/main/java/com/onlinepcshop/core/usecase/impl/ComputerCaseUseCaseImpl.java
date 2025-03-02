package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.ComputerCase;
import com.onlinepcshop.core.repository.ComputerCaseRepository;
import com.onlinepcshop.core.repository.ProductRatingRepository;
import com.onlinepcshop.core.usecase.ComputerCaseUseCase;
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
public class ComputerCaseUseCaseImpl implements ComputerCaseUseCase {
    private final ComputerCaseRepository computerCaseRepository;
    private final ProductRatingRepository productRatingRepository;

    @Override
    public ComputerCase createComputerCase(ComputerCase computerCase) {
        return computerCaseRepository.saveComputerCase(computerCase);
    }

    @Override
    public ComputerCase updateComputerCase(ComputerCase computerCase) {
        return computerCaseRepository.saveComputerCase(computerCase);
    }

    @Override
    public List<ComputerCase> findAllComputerCases() {
        return computerCaseRepository.findAllComputerCases().stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public List<ComputerCase> findAllAvailableComputerCases() {
        return computerCaseRepository.findAllAvailableComputerCases().stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ComputerCase> findComputerCaseById(UUID computerCaseId) {
        return computerCaseRepository.findById(computerCaseId);
    }

    @Override
    public void deleteComputerCase(UUID id) {
        computerCaseRepository.deleteComputerCase(id);
    }

    @Override
    public List<ComputerCase> findAllComputerCasesByMaxPrice(Double maxPrice) {
        return computerCaseRepository.findAllComputerCasesByMaxPrice(maxPrice).stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public List<ComputerCase> searchByName(String name) {
        return computerCaseRepository.searchByComponentName(name).stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public Double getComputerCaseAverageRating(UUID computerCaseId) {
        return productRatingRepository.findAverageRatingByProductId(computerCaseId);
    }
}
