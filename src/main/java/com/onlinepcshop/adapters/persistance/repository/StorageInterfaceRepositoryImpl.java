package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.StorageInterfaceDao;
import com.onlinepcshop.adapters.persistance.mapper.StorageInterfaceMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.StorageInterfaceJpaRepository;
import com.onlinepcshop.core.domain.entity.StorageInterface;
import com.onlinepcshop.core.repository.StorageInterfaceRepository;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public class StorageInterfaceRepositoryImpl implements StorageInterfaceRepository {
    private final StorageInterfaceJpaRepository storageInterfaceJpaRepository;

    @Override
    public List<StorageInterface> findAllStorageInterfaces() {
        return StorageInterfaceMapperDB.INSTANCE.storageInterfaceDaoListToStorageInterfaceList(storageInterfaceJpaRepository.findAll());
    }

    @Override
    public Optional<StorageInterface> findById(UUID storageInterfaceId) {
        StorageInterface storageInterface = StorageInterfaceMapperDB.INSTANCE.storageInterfaceDaoToStorageInterface(storageInterfaceJpaRepository.findById(storageInterfaceId).orElse(null));
        return Optional.ofNullable(storageInterface);
    }

    @Override
    public StorageInterface saveStorageInterface(StorageInterface storageInterface) {
        StorageInterfaceDao storageInterfaceDao = StorageInterfaceMapperDB.INSTANCE.storageInterfaceToStorageInterfaceDao(storageInterface);
        return StorageInterfaceMapperDB.INSTANCE.storageInterfaceDaoToStorageInterface(storageInterfaceJpaRepository.save(storageInterfaceDao));
    }

    @Override
    public void deleteStorageInterface(UUID id) {
        storageInterfaceJpaRepository.deleteById(id);
    }
}
