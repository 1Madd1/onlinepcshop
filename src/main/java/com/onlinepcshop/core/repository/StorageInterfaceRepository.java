package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.StorageInterface;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StorageInterfaceRepository {
    List<StorageInterface> findAllStorageInterfaces();

    Optional<StorageInterface> findById(UUID storageInterfaceId);

    StorageInterface saveStorageInterface(StorageInterface storageInterface);

    void deleteStorageInterface(UUID id);
}
