package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.ComputerCase;
import com.onlinepcshop.core.domain.entity.Motherboard;
import com.onlinepcshop.core.domain.entity.MotherboardStorageInterface;
import com.onlinepcshop.core.repository.ComputerCaseRepository;
import com.onlinepcshop.core.usecase.ComputerCaseUseCase;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Builder
public class ComputerCaseUseCaseImpl implements ComputerCaseUseCase {
    private final ComputerCaseRepository computerCaseRepository;

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
        return computerCaseRepository.findAllComputerCases();
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
        return computerCaseRepository.findAllComputerCasesByMaxPrice(maxPrice);
    }
}
