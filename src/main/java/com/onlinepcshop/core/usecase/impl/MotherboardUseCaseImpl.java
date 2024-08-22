package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.Motherboard;
import com.onlinepcshop.core.repository.MotherboardRepository;
import com.onlinepcshop.core.usecase.MotherboardUseCase;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Builder
public class MotherboardUseCaseImpl implements MotherboardUseCase {
    private final MotherboardRepository motherboardRepository;

    @Override
    public Motherboard createMotherboard(Motherboard motherboard) {
        return motherboardRepository.saveMotherboard(motherboard);
    }

    @Override
    public Motherboard updateMotherboard(Motherboard motherboard) {
        return motherboardRepository.saveMotherboard(motherboard);
    }

    @Override
    public List<Motherboard> findAllMotherboards() {
        return motherboardRepository.findAllMotherboards();
    }

    @Override
    public Optional<Motherboard> findMotherboardById(UUID motherboardId) {
        return motherboardRepository.findById(motherboardId);
    }

    @Override
    public void deleteMotherboard(UUID id) {
        motherboardRepository.deleteMotherboard(id);
    }
}
