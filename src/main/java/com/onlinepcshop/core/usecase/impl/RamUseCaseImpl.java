package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.Ram;
import com.onlinepcshop.core.domain.entity.ComputerRam;
import com.onlinepcshop.core.repository.ComputerRamRepository;
import com.onlinepcshop.core.repository.RamRepository;
import com.onlinepcshop.core.usecase.RamUseCase;
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
public class RamUseCaseImpl implements RamUseCase {
    private final RamRepository ramRepository;
    private final ComputerRamRepository computerRamRepository;

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
        return ramRepository.findAllRams();
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
            ramList.add(cr.getRam());
        }
        return ramList;
    }

    @Override
    public Integer findQuantityByRamIdAndComputerId(UUID ramId, UUID computerId) {
        return computerRamRepository.findQuantityByRamIdAndComputerId(ramId, computerId);
    }
}
