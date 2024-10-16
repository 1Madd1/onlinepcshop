package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.MotherboardStorageInterfaceDao;
import com.onlinepcshop.adapters.persistance.mapper.MotherboardStorageInterfaceMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.MotherboardStorageInterfaceJpaRepository;
import com.onlinepcshop.core.domain.entity.MotherboardStorageInterface;
import com.onlinepcshop.core.repository.MotherboardStorageInterfaceRepository;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public class MotherboardStorageInterfaceRepositoryImpl implements MotherboardStorageInterfaceRepository {
    private final MotherboardStorageInterfaceJpaRepository motherboardStorageInterfaceJpaRepository;

    @Override
    public List<MotherboardStorageInterface> findAllMotherboardStorageInterfaces() {
        return MotherboardStorageInterfaceMapperDB.INSTANCE.motherboardStorageInterfaceDaoListToMotherboardStorageInterfaceList(motherboardStorageInterfaceJpaRepository.findAll());
    }

    @Override
    public Optional<MotherboardStorageInterface> findById(UUID motherboardStorageInterfaceId) {
        MotherboardStorageInterface motherboardStorageInterface = MotherboardStorageInterfaceMapperDB.INSTANCE.motherboardStorageInterfaceDaoToMotherboardStorageInterface(motherboardStorageInterfaceJpaRepository.findById(motherboardStorageInterfaceId).orElse(null));
        return Optional.ofNullable(motherboardStorageInterface);
    }

    @Override
    public MotherboardStorageInterface saveMotherboardStorageInterface(MotherboardStorageInterface motherboardStorageInterface) {
        MotherboardStorageInterfaceDao motherboardStorageInterfaceDao = MotherboardStorageInterfaceMapperDB.INSTANCE.motherboardStorageInterfaceToMotherboardStorageInterfaceDao(motherboardStorageInterface);
        return MotherboardStorageInterfaceMapperDB.INSTANCE.motherboardStorageInterfaceDaoToMotherboardStorageInterface(motherboardStorageInterfaceJpaRepository.save(motherboardStorageInterfaceDao));
    }

    @Override
    public void deleteMotherboardStorageInterface(UUID id) {
        motherboardStorageInterfaceJpaRepository.deleteById(id);
    }

    @Override
    public List<MotherboardStorageInterface> findAllByStorageInterfaceAndMotherboard(UUID storageInterfaceId, UUID motherboardId) {
        return MotherboardStorageInterfaceMapperDB.INSTANCE.motherboardStorageInterfaceDaoListToMotherboardStorageInterfaceList(motherboardStorageInterfaceJpaRepository.findAllByMotherboardIdAndStorageInterfaceId(motherboardId, storageInterfaceId));
    }

    @Override
    public List<MotherboardStorageInterface> findAllByMotherboardId(UUID motherboardId) {
        return MotherboardStorageInterfaceMapperDB.INSTANCE.motherboardStorageInterfaceDaoListToMotherboardStorageInterfaceList(motherboardStorageInterfaceJpaRepository.findAllByMotherboardId(motherboardId));
    }
}
