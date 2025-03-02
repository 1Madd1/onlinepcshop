package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.StorageDao;
import com.onlinepcshop.adapters.persistance.mapper.StorageMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.StorageJpaRepository;
import com.onlinepcshop.core.domain.entity.Storage;
import com.onlinepcshop.core.repository.StorageRepository;
import lombok.Builder;

import java.time.LocalDate;
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
    public List<Storage> findAllAvailableStorages() {
        return StorageMapperDB.INSTANCE.storageDaoListToStorageList(storageJpaRepository.findAllByQuantityGreaterThan(0));
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

    @Override
    public List<Storage> findAllStoragesByMaxPriceAndStorageInterface(Double maxPrice, String storageType) {
        return StorageMapperDB.INSTANCE.storageDaoListToStorageList(storageJpaRepository.findByPriceLessThanEqualAndStorageTypeAndQuantityGreaterThan(maxPrice, storageType, 0));
    }

    @Override
    public List<Storage> findAllByHavingSaleAndByComponentName(String componentName) {
        return StorageMapperDB.INSTANCE.storageDaoListToStorageList(storageJpaRepository.findBySaleTypeNotNullAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(componentName, 0));
    }

    @Override
    public List<Storage> searchByComponentName(String componentName) {
        return StorageMapperDB.INSTANCE.storageDaoListToStorageList(storageJpaRepository.findByComponentNameContainingIgnoreCaseAndQuantityGreaterThan(componentName, 0));
    }

    @Override
    public List<Storage> findAllNewStoragesByComponentName(String componentName) {
        LocalDate localDate = LocalDate.now().minusMonths(1);
        return StorageMapperDB.INSTANCE.storageDaoListToStorageList(storageJpaRepository.findByDateOfCreationAfterAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(localDate, componentName, 0));
    }
}
