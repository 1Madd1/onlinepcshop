package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.PcieInterface;
import com.onlinepcshop.core.repository.PcieInterfaceRepository;
import com.onlinepcshop.core.usecase.PcieInterfaceUseCase;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Builder
public class PcieInterfaceUseCaseImpl implements PcieInterfaceUseCase {
    private final PcieInterfaceRepository pcieInterfaceRepository;

    @Override
    public PcieInterface createPcieInterface(PcieInterface pcieInterface) {
        return pcieInterfaceRepository.savePcieInterface(pcieInterface);
    }

    @Override
    public PcieInterface updatePcieInterface(PcieInterface pcieInterface) {
        return pcieInterfaceRepository.savePcieInterface(pcieInterface);
    }

    @Override
    public List<PcieInterface> findAllPcieInterfaces() {
        return pcieInterfaceRepository.findAllPcieInterfaces();
    }

    @Override
    public Optional<PcieInterface> findPcieInterfaceById(UUID pcieInterfaceId) {
        return pcieInterfaceRepository.findById(pcieInterfaceId);
    }

    @Override
    public void deletePcieInterface(UUID id) {
        pcieInterfaceRepository.deletePcieInterface(id);
    }
}
