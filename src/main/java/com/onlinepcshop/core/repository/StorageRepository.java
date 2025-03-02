package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.Storage;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StorageRepository {
    List<Storage> findAllStorages();

    List<Storage> findAllAvailableStorages();

    Optional<Storage> findById(UUID storageId);

    Storage saveStorage(Storage storage);

    void deleteStorage(UUID id);

    List<Storage> findAllStoragesByMaxPriceAndStorageInterface(Double maxPrice, String storageType);

    List<Storage> findAllByHavingSaleAndByComponentName(String componentName);

    List<Storage> searchByComponentName(String componentName);

    List<Storage> findAllNewStoragesByComponentName(String componentName);
}
