package com.onlinepcshop.core.usecase;

import com.onlinepcshop.core.domain.entity.StorageInterface;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StorageInterfaceUseCase {
    /***
     *  Create and persist an agent
     *
     * @param storageInterface newly created storage interface
     * @return Valid user object with id
     */
    StorageInterface createStorageInterface(StorageInterface storageInterface);

    /***
     *  Update storageInterface data fields
     * @param storageInterface must be a valid storage interface object with valid id
     * @return Updated storageInterface object
     */
    StorageInterface updateStorageInterface(StorageInterface storageInterface);

    /***
     *
     * @return List of all storage interfaces
     */
    List<StorageInterface> findAllStorageInterfaces();


    /***
     * @param storageInterfaceId valid storage interface UUID
     * @return StorageInterface with provided agentId if one exists
     */
    Optional<StorageInterface> findStorageInterfaceById(UUID storageInterfaceId);

    /***
     * Delete storage interface with specified id
     * @param id must be a valid
     */
    void deleteStorageInterface(UUID id);
}
