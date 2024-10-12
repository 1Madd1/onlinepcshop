package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.Gpu;
import com.onlinepcshop.core.domain.entity.MotherboardPcieInterface;
import com.onlinepcshop.core.domain.entity.PcieInterface;
import com.onlinepcshop.core.repository.GpuRepository;
import com.onlinepcshop.core.repository.MotherboardPcieInterfaceRepository;
import com.onlinepcshop.core.repository.PcieInterfaceRepository;
import com.onlinepcshop.core.usecase.GpuUseCase;
import com.onlinepcshop.core.util.GpuComparator;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@RequiredArgsConstructor
@Slf4j
@Builder
public class GpuUseCaseImpl implements GpuUseCase {
    private final GpuRepository gpuRepository;
    private final MotherboardPcieInterfaceRepository motherboardPcieInterfaceRepository;
    private final PcieInterfaceRepository pcieInterfaceRepository;

    @Override
    public Gpu createGpu(Gpu gpu) {
        return gpuRepository.saveGpu(gpu);
    }

    @Override
    public Gpu updateGpu(Gpu gpu) {
        return gpuRepository.saveGpu(gpu);
    }

    @Override
    public List<Gpu> findAllGpus() {
        return gpuRepository.findAllGpus();
    }

    @Override
    public Optional<Gpu> findGpuById(UUID gpuId) {
        return gpuRepository.findById(gpuId);
    }

    @Override
    public void deleteGpu(UUID id) {
        gpuRepository.deleteGpu(id);
    }

    @Override
    public List<Gpu> findAllGpusByMaxPriceAndMotherboard(Double maxPrice, UUID motherboardId) {
        List<MotherboardPcieInterface> motherboardPcieInterfaceList = motherboardPcieInterfaceRepository.findAllByMotherboardId(motherboardId);
        List<Gpu> filteredGpuList;
        List<Gpu> finalGpuList = new ArrayList<>();
        for (MotherboardPcieInterface motherboardPcieInterface : motherboardPcieInterfaceList) {
            Optional<PcieInterface> optionalPcieInterface = pcieInterfaceRepository.findById(motherboardPcieInterface.getPcieInterface().getId());
            if (optionalPcieInterface.isPresent()) {
                filteredGpuList = gpuRepository.findAllGpusByMaxPriceAndPcieInterface(maxPrice, optionalPcieInterface.get().getPcieType().toString());
                finalGpuList.addAll(filteredGpuList);
            }
        }
        Collections.sort(finalGpuList, new GpuComparator());
        return finalGpuList;
    }
}
