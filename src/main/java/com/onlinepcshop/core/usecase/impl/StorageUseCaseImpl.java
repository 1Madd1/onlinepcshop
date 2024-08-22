package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.Storage;
import com.onlinepcshop.core.repository.StorageRepository;
import com.onlinepcshop.core.usecase.StorageUseCase;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Builder
public class StorageUseCaseImpl implements StorageUseCase {
    private final StorageRepository storageRepository;

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
}
