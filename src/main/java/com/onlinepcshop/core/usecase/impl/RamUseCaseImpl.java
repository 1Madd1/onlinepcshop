package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.ComputerRam;
import com.onlinepcshop.core.domain.entity.Ram;
import com.onlinepcshop.core.repository.ComputerRamRepository;
import com.onlinepcshop.core.repository.ProductRatingRepository;
import com.onlinepcshop.core.repository.RamRepository;
import com.onlinepcshop.core.usecase.RamUseCase;
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
public class RamUseCaseImpl implements RamUseCase {
    private final RamRepository ramRepository;
    private final ComputerRamRepository computerRamRepository;
    private final ProductRatingRepository productRatingRepository;

    @Override
    public Ram createRam(Ram ram) {
        return ramRepository.saveRam(ram);
    }

    @Override
    public Ram updateRam(Ram ram) {
        return ramRepository.saveRam(ram);
    }

    @Override
    public List<Ram> findAllRams() {
        return ramRepository.findAllRams().stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Ram> findAllAvailableRams() {
        return ramRepository.findAllAvailableRams().stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Ram> findRamById(UUID ramId) {
        return ramRepository.findById(ramId);
    }

    @Override
    public void deleteRam(UUID id) {
        ramRepository.deleteRam(id);
    }

    @Override
    public List<Ram> findAllRamsByMaxPriceAndMemoryType(Double maxPrice, String memoryType) {
        return ramRepository.findAllRamsByMaxPriceAndMemoryType(maxPrice, memoryType);
    }

    @Override
    public List<Ram> findAllRamsByComputerId(UUID computerId) {
        List<Ram> ramList = new ArrayList<>();
        for (ComputerRam cr : computerRamRepository.findAllByComputer(computerId)) {
            Ram ram = cr.getRam();
            ram.setAvgRating(productRatingRepository.findAverageRatingByProductId(ram.getId()));
            ramList.add(ram);
        }
        return ramList;
    }

    @Override
    public Integer findQuantityByRamIdAndComputerId(UUID ramId, UUID computerId) {
        return computerRamRepository.findQuantityByRamIdAndComputerId(ramId, computerId);
    }

    @Override
    public List<Ram> searchByName(String name) {
        return ramRepository.searchByComponentName(name).stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public Double getRamAverageRating(UUID ramId) {
        return productRatingRepository.findAverageRatingByProductId(ramId);
    }
}
