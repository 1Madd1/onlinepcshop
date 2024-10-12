package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.*;
import com.onlinepcshop.core.repository.ComputerStorageRepository;
import com.onlinepcshop.core.repository.MotherboardStorageInterfaceRepository;
import com.onlinepcshop.core.repository.StorageInterfaceRepository;
import com.onlinepcshop.core.repository.StorageRepository;
import com.onlinepcshop.core.usecase.StorageUseCase;
import com.onlinepcshop.core.util.GpuComparator;
import com.onlinepcshop.core.util.StorageComparator;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@RequiredArgsConstructor
@Slf4j
@Builder
public class StorageUseCaseImpl implements StorageUseCase {
    private final StorageRepository storageRepository;
    private final MotherboardStorageInterfaceRepository motherboardStorageInterfaceRepository;
    private final StorageInterfaceRepository storageInterfaceRepository;
    private final ComputerStorageRepository computerStorageRepository;

    @Override
    public Storage createStorage(Storage storage) {
        return storageRepository.saveStorage(storage);
    }

    @Override
    public Storage updateStorage(Storage storage) {
        return storageRepository.saveStorage(storage);
    }

    @Override
    public List<Storage> findAllStorages() {
        return storageRepository.findAllStorages();
    }

    @Override
    public Optional<Storage> findStorageById(UUID storageId) {
        return storageRepository.findById(storageId);
    }

    @Override
    public void deleteStorage(UUID id) {
        storageRepository.deleteStorage(id);
    }

    @Override
    public List<Storage> findAllStoragesByMaxPriceAndMotherboard(Double maxPrice, UUID motherboardId) {
        List<MotherboardStorageInterface> motherboardStorageInterfaceList = motherboardStorageInterfaceRepository.findAllByMotherboardId(motherboardId);
        List<Storage> filteredStorageList;
        Set<String> storageTypes = new HashSet<>();
        List<Storage> finalStorageList = new ArrayList<>();
        for (MotherboardStorageInterface motherboardStorageInterface : motherboardStorageInterfaceList) {
            Optional<StorageInterface> optionalStorageInterface = storageInterfaceRepository.findById(motherboardStorageInterface.getStorageInterface().getId());
            if (optionalStorageInterface.isPresent()) {
                storageTypes.add(optionalStorageInterface.get().getStorageType().toString());
            }
        }
        for (String storageType : storageTypes) {
            filteredStorageList = storageRepository.findAllStoragesByMaxPriceAndStorageInterface(maxPrice, storageType);
            finalStorageList.addAll(filteredStorageList);
        }
        Collections.sort(finalStorageList, new StorageComparator());
        return finalStorageList;
    }

    @Override
    public List<Storage> findAllStoragesByComputerId(UUID computerId) {
        List<Storage> storageList = new ArrayList<>();
        for (ComputerStorage ccf : computerStorageRepository.findAllByComputer(computerId)) {
            storageList.add(ccf.getStorage());
        }
        return storageList;
    }

    @Override
    public Integer findQuantityByStorageIdAndComputerId(UUID storageId, UUID computerId) {
        return computerStorageRepository.findQuantityByStorageIdAndComputerId(storageId, computerId);
    }
}
