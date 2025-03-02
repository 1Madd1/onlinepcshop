package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.CaseFan;
import com.onlinepcshop.core.domain.entity.ComputerCaseFan;
import com.onlinepcshop.core.repository.CaseFanRepository;
import com.onlinepcshop.core.repository.ComputerCaseFanRepository;
import com.onlinepcshop.core.repository.ProductRatingRepository;
import com.onlinepcshop.core.usecase.CaseFanUseCase;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Builder
public class CaseFanUseCaseImpl implements CaseFanUseCase {
    private final CaseFanRepository caseFanRepository;
    private final ProductRatingRepository productRatingRepository;
    private final ComputerCaseFanRepository computerCaseFanRepository;

    @Override
    public CaseFan createCaseFan(CaseFan caseFan) {
        return caseFanRepository.saveCaseFan(caseFan);
    }

    @Override
    public CaseFan updateCaseFan(CaseFan caseFan) {
        return caseFanRepository.saveCaseFan(caseFan);
    }

    @Override
    public List<CaseFan> findAllCaseFans() {
        return caseFanRepository.findAllCaseFans().stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public List<CaseFan> findAllAvailableCaseFans() {
        return caseFanRepository.findAllAvailableCaseFans().stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CaseFan> findCaseFanById(UUID caseFanId) {
        return caseFanRepository.findById(caseFanId);
    }

    @Override
    public void deleteCaseFan(UUID id) {
        caseFanRepository.deleteCaseFan(id);
    }

    @Override
    public List<CaseFan> findAllCaseFansByMaxPrice(Double maxPrice) {
        return caseFanRepository.findAllCaseFansByMaxPrice(maxPrice).stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public List<CaseFan> findAllCaseFansByComputerId(UUID computerId) {
        List<CaseFan> caseFanList = new ArrayList<>();
        for (ComputerCaseFan ccf : computerCaseFanRepository.findAllByComputer(computerId)) {
            CaseFan caseFan = ccf.getCaseFan();
            caseFan.setAvgRating(productRatingRepository.findAverageRatingByProductId(caseFan.getId()));
            caseFanList.add(caseFan);
        }
        return caseFanList;
    }

    @Override
    public Integer findQuantityByCaseFanIdAndComputerId(UUID caseFanId, UUID computerId) {
        return computerCaseFanRepository.findQuantityByCaseFanIdAndComputerId(caseFanId, computerId);
    }

    @Override
    public Double getCaseFanAverageRating(UUID caseFanId) {
        return productRatingRepository.findAverageRatingByProductId(caseFanId);
    }

    @Override
    public List<CaseFan> searchByName(String name) {
        return caseFanRepository.searchByComponentName(name).stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
    }
}
