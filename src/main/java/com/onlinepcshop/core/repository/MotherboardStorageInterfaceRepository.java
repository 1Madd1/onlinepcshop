package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.MotherboardStorageInterface;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MotherboardStorageInterfaceRepository {
    List<MotherboardStorageInterface> findAllMotherboardStorageInterfaces();

    Optional<MotherboardStorageInterface> findById(UUID motherboardStorageInterfaceId);

    MotherboardStorageInterface saveMotherboardStorageInterface(MotherboardStorageInterface motherboardStorageInterface);

    void deleteMotherboardStorageInterface(UUID id);

    List<MotherboardStorageInterface> findAllByStorageInterfaceAndMotherboard(UUID storageInterfaceId, UUID motherboardId);
}

