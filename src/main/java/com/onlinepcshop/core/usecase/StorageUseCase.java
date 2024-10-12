package com.onlinepcshop.core.usecase;

import com.onlinepcshop.core.domain.entity.MotherboardStorageInterface;
import com.onlinepcshop.core.domain.entity.Storage;
import com.onlinepcshop.core.domain.entity.StorageInterface;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StorageUseCase {
    /***
     *  Create and persist an agent
     *
     * @param storage newly created storage
     * @return Valid user object with id
     */
    Storage createStorage(Storage storage);

    /***
     *  Update storage data fields
     * @param storage must be a valid storage object with valid id
     * @return Updated storage object
     */
    Storage updateStorage(Storage storage);

    /***
     *
     * @return List of all storages
     */
    List<Storage> findAllStorages();


    /***
     * @param storageId valid storage UUID
     * @return Storage with provided agentId if one exists
     */
    Optional<Storage> findStorageById(UUID storageId);

    /***
     * Delete storage with specified id
     * @param id must be a valid
     */
    void deleteStorage(UUID id);

    /**
     *
     * @param maxPrice - max. price of storage
     * @param motherboardId - id of given motherboard
     * @return - List of storages that are the same or below max. price and are compatible with given motherboard
     */
    List<Storage> findAllStoragesByMaxPriceAndMotherboard(Double maxPrice, UUID motherboardId);

    /**
     *
     * @param computerId - valid UUID of existing computer
     * @return - List of all storages that have the same computer id
     */
    List<Storage> findAllStoragesByComputerId(UUID computerId);

    /**
     *
     * @param storageId - valid UUID of existing storage
     * @param computerId - valid UUID of existing computer
     * @return - amount of storages that are assigned to the computer
     */
    Integer findQuantityByStorageIdAndComputerId(UUID storageId, UUID computerId);
}
