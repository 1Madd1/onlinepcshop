package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.MotherboardPcieInterface;
import com.onlinepcshop.core.domain.entity.PcieInterface;
import com.onlinepcshop.core.repository.MotherboardPcieInterfaceRepository;
import com.onlinepcshop.core.repository.PcieInterfaceRepository;
import com.onlinepcshop.core.usecase.PcieInterfaceUseCase;
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
public class PcieInterfaceUseCaseImpl implements PcieInterfaceUseCase {
    private final PcieInterfaceRepository pcieInterfaceRepository;
    private final MotherboardPcieInterfaceRepository motherboardPcieInterfaceRepository;

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

    @Override
    public List<PcieInterface> findAllPcieInterfacesByMotherboard(UUID motherboardId) {
        List<PcieInterface> pcieInterfaceList = new ArrayList<>();
        List<MotherboardPcieInterface> motherboardPcieInterfaceList = motherboardPcieInterfaceRepository.findAllByMotherboardId(motherboardId);
        for(MotherboardPcieInterface motherboardPcieInterface : motherboardPcieInterfaceList) {
            pcieInterfaceList.add(motherboardPcieInterface.getPcieInterface());
        }
        return pcieInterfaceList;
    }
}
