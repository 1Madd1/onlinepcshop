package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.ComputerStorageDao;
import com.onlinepcshop.adapters.persistance.mapper.ComputerStorageMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.ComputerStorageJpaRepository;
import com.onlinepcshop.core.domain.entity.ComputerStorage;
import com.onlinepcshop.core.repository.ComputerStorageRepository;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public class ComputerStorageRepositoryImpl implements ComputerStorageRepository {
    private final ComputerStorageJpaRepository computerStorageJpaRepository;

    @Override
    public List<ComputerStorage> findAllComputerStorages() {
        return ComputerStorageMapperDB.INSTANCE.computerStorageDaoListToComputerStorageList(computerStorageJpaRepository.findAll());
    }

    @Override
    public Optional<ComputerStorage> findById(UUID computerStorageId) {
        ComputerStorage computerStorage = ComputerStorageMapperDB.INSTANCE.computerStorageDaoToComputerStorage(computerStorageJpaRepository.findById(computerStorageId).orElse(null));
        return Optional.ofNullable(computerStorage);
    }

    @Override
    public ComputerStorage saveComputerStorage(ComputerStorage computerStorage) {
        ComputerStorageDao computerStorageDao = ComputerStorageMapperDB.INSTANCE.computerStorageToComputerStorageDao(computerStorage);
        return ComputerStorageMapperDB.INSTANCE.computerStorageDaoToComputerStorage(computerStorageJpaRepository.save(computerStorageDao));
    }

    @Override
    public void deleteComputerStorage(UUID id) {
        computerStorageJpaRepository.deleteById(id);
    }
}
