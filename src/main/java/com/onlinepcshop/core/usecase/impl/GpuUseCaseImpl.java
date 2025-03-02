package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.Gpu;
import com.onlinepcshop.core.domain.entity.MotherboardPcieInterface;
import com.onlinepcshop.core.domain.entity.PcieInterface;
import com.onlinepcshop.core.repository.GpuRepository;
import com.onlinepcshop.core.repository.MotherboardPcieInterfaceRepository;
import com.onlinepcshop.core.repository.PcieInterfaceRepository;
import com.onlinepcshop.core.repository.ProductRatingRepository;
import com.onlinepcshop.core.usecase.GpuUseCase;
import com.onlinepcshop.core.util.GpuComparator;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Builder
public class GpuUseCaseImpl implements GpuUseCase {
    private final GpuRepository gpuRepository;
    private final MotherboardPcieInterfaceRepository motherboardPcieInterfaceRepository;
    private final PcieInterfaceRepository pcieInterfaceRepository;
    private final ProductRatingRepository productRatingRepository;

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
        return gpuRepository.findAllGpus().stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Gpu> findAllAvailableGpus() {
        return gpuRepository.findAllAvailableGpus().stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
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
                filteredGpuList = gpuRepository.findAllGpusByMaxPriceAndPcieInterface(maxPrice, optionalPcieInterface.get().getPcieType().toString()).stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList());
                finalGpuList.addAll(filteredGpuList);
            }
        }
        Collections.sort(finalGpuList, new GpuComparator());
        return finalGpuList;
    }

    @Override
    public List<Gpu> searchByName(String name) {
        return gpuRepository.searchByComponentName(name).stream()
                .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public Double getGpuAverageRating(UUID gpuId) {
        return productRatingRepository.findAverageRatingByProductId(gpuId);
    }
}
