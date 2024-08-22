package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.Storage;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StorageRepository {
    List<Storage> findAllStorages();

    Optional<Storage> findById(UUID storageId);

    Storage saveStorage(Storage storage);

    void deleteStorage(UUID id);
}
