package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.*;
import com.onlinepcshop.core.error.exception.*;
import com.onlinepcshop.core.repository.*;
import com.onlinepcshop.core.usecase.MotherboardUseCase;
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
public class MotherboardUseCaseImpl implements MotherboardUseCase {
    private final MotherboardRepository motherboardRepository;
    private final PcieInterfaceRepository pcieInterfaceRepository;
    private final StorageInterfaceRepository storageInterfaceRepository;
    private final MotherboardPcieInterfaceRepository motherboardPcieInterfaceRepository;
    private final MotherboardStorageInterfaceRepository motherboardStorageInterfaceRepository;

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

    @Override
    public MotherboardPcieInterface assignPcieInterface(UUID pcieInterfaceId, UUID motherboardId) {
        Optional<PcieInterface> pcieInterfaceOptional = pcieInterfaceRepository.findById(pcieInterfaceId);
        if(pcieInterfaceOptional.isEmpty()) {
            System.out.println("PCIe interface with id " + pcieInterfaceId + " not found");
            throw new PcieInterfaceNotFoundException("PcieInterface with id " + pcieInterfaceId + " not found");
        }
        Optional<Motherboard> motherboardOptional = motherboardRepository.findById(motherboardId);

        if(motherboardOptional.isEmpty()) {
            System.out.println("Motherboard with id " + motherboardId + " not found");
            throw new MotherboardNotFoundException("Motherboard with id " + motherboardId + "not found");
        }

        for(MotherboardPcieInterface motherboardPcieInterface : motherboardPcieInterfaceRepository.findAllByPcieInterfaceAndMotherboard(pcieInterfaceId, motherboardId)) {
            if (motherboardPcieInterface.getMotherboard().getId().equals(motherboardId)) {
                if (motherboardPcieInterface.getPcieInterface().getId().equals(pcieInterfaceId)) {
                    return null;
                }
            }
        }

        MotherboardPcieInterface motherboardPcieInterface = MotherboardPcieInterface.builder()
                .motherboard(Motherboard.builder().id(motherboardId).build())
                .pcieInterface(PcieInterface.builder().id(pcieInterfaceId).build())
                .build();
        return motherboardPcieInterfaceRepository.saveMotherboardPcieInterface(motherboardPcieInterface);
    }

    @Override
    public void unassignPcieInterface(UUID pcieInterfaceId, UUID motherboardId) {
        List<MotherboardPcieInterface> motherboardPcieInterfaceList =
                motherboardPcieInterfaceRepository.findAllByPcieInterfaceAndMotherboard(pcieInterfaceId, motherboardId);
        if(motherboardPcieInterfaceList.isEmpty()) {
            System.out.println("Motherboard with id " + motherboardId + ", has no PCIe interface with id " + pcieInterfaceId + " assigned");
            throw new PcieInterfaceNotAssignedException("Motherboard with id " + motherboardId + ", has no PcieInterface with id " + pcieInterfaceId +" assigned.");
        }

        MotherboardPcieInterface motherboardPcieInterface = motherboardPcieInterfaceList.get(0);

        motherboardPcieInterfaceRepository.deleteMotherboardPcieInterface(motherboardPcieInterface.getId());
    }

    @Override
    public MotherboardStorageInterface assignStorageInterface(UUID storageInterfaceId, UUID motherboardId) {
        Optional<StorageInterface> storageInterfaceOptional = storageInterfaceRepository.findById(storageInterfaceId);

        if(storageInterfaceOptional.isEmpty()) {
            System.out.println("Storage interface with id " + storageInterfaceId + " not found");
            throw new StorageInterfaceNotFoundException("StorageInterface with id " + storageInterfaceId + " not found");
        }

        Optional<Motherboard> motherboardOptional = motherboardRepository.findById(motherboardId);

        if(motherboardOptional.isEmpty()) {
            System.out.println("Motherboard with id " + motherboardId + " not found");
            throw new MotherboardNotFoundException("Motherboard with id " + motherboardId + "not found");
        }

        for(MotherboardStorageInterface motherboardStorageInterface : motherboardStorageInterfaceRepository.findAllByStorageInterfaceAndMotherboard(storageInterfaceId, motherboardId)) {
            if (motherboardStorageInterface.getMotherboard().getId().equals(motherboardId)) {
                if (motherboardStorageInterface.getStorageInterface().getId().equals(storageInterfaceId)) {
                    return null;
                }
            }
        }

        MotherboardStorageInterface motherboardStorageInterface = MotherboardStorageInterface.builder()
                .motherboard(Motherboard.builder().id(motherboardId).build())
                .storageInterface(StorageInterface.builder().id(storageInterfaceId).build())
                .build();

        return motherboardStorageInterfaceRepository.saveMotherboardStorageInterface(motherboardStorageInterface);
    }

    @Override
    public void unassignStorageInterface(UUID storageInterfaceId, UUID motherboardId) {
        List<MotherboardStorageInterface> motherboardStorageInterfaceList =
                motherboardStorageInterfaceRepository.findAllByStorageInterfaceAndMotherboard(storageInterfaceId, motherboardId);
        if(motherboardStorageInterfaceList.isEmpty()) {
            System.out.println("Motherboard with id " + motherboardId + ", has no storage interface with id " + storageInterfaceId + " assigned");
            throw new PcieInterfaceNotAssignedException("Motherboard with id " + motherboardId + ", has no StorageInterface with id " + storageInterfaceId +" assigned.");
        }

        MotherboardStorageInterface motherboardStorageInterface = motherboardStorageInterfaceList.get(0);

        motherboardStorageInterfaceRepository.deleteMotherboardStorageInterface(motherboardStorageInterface.getId());
    }

    @Override
    public List<Motherboard> findAllMotherboardsByMaxPriceAndByStorageInterfaceLimit(Double maxPrice, Integer storageInterfaceLimit) {
        List<Motherboard> motherboardResultList = new ArrayList<>();
        List<Motherboard> motherboardList = motherboardRepository.findAllMotherboardsByMaxPrice(maxPrice);
        for(Motherboard motherboard : motherboardList) {
            List<MotherboardStorageInterface> motherboardStorageInterfaceList = motherboardStorageInterfaceRepository.findAllByMotherboardId(motherboard.getId());
            if(motherboardStorageInterfaceList.size() <= storageInterfaceLimit) {
                motherboardResultList.add(motherboard);
            }
        }
        return motherboardResultList;
    }
}
