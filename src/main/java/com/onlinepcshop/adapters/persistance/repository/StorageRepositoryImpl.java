package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.StorageDao;
import com.onlinepcshop.adapters.persistance.mapper.StorageMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.StorageJpaRepository;
import com.onlinepcshop.core.domain.entity.Storage;
import com.onlinepcshop.core.repository.StorageRepository;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public class StorageRepositoryImpl implements StorageRepository {
    private final StorageJpaRepository storageJpaRepository;

    @Override
    public List<Storage> findAllStorages() {
        return StorageMapperDB.INSTANCE.storageDaoListToStorageList(storageJpaRepository.findAll());
    }

    @Override
    public Optional<Storage> findById(UUID storageId) {
        Storage storage = StorageMapperDB.INSTANCE.storageDaoToStorage(storageJpaRepository.findById(storageId).orElse(null));
        return Optional.ofNullable(storage);
    }

    @Override
    public Storage saveStorage(Storage storage) {
        StorageDao storageDao = StorageMapperDB.INSTANCE.storageToStorageDao(storage);
        return StorageMapperDB.INSTANCE.storageDaoToStorage(storageJpaRepository.save(storageDao));
    }

    @Override
    public void deleteStorage(UUID id) {
        storageJpaRepository.deleteById(id);
    }
}
