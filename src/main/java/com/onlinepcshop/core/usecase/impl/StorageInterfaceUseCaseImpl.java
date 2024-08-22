package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.StorageInterface;
import com.onlinepcshop.core.repository.StorageInterfaceRepository;
import com.onlinepcshop.core.usecase.StorageInterfaceUseCase;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Builder
public class StorageInterfaceUseCaseImpl implements StorageInterfaceUseCase {
    private final StorageInterfaceRepository storageInterfaceRepository;

    @Override
    public StorageInterface createStorageInterface(StorageInterface storageInterface) {
        return storageInterfaceRepository.saveStorageInterface(storageInterface);
    }

    @Override
    public StorageInterface updateStorageInterface(StorageInterface storageInterface) {
        return storageInterfaceRepository.saveStorageInterface(storageInterface);
    }

    @Override
    public List<StorageInterface> findAllStorageInterfaces() {
        return storageInterfaceRepository.findAllStorageInterfaces();
    }

    @Override
    public Optional<StorageInterface> findStorageInterfaceById(UUID storageInterfaceId) {
        return storageInterfaceRepository.findById(storageInterfaceId);
    }

    @Override
    public void deleteStorageInterface(UUID id) {
        storageInterfaceRepository.deleteStorageInterface(id);
    }
}
