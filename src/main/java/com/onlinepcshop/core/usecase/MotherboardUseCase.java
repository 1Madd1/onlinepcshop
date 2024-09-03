package com.onlinepcshop.core.usecase;

import com.onlinepcshop.core.domain.entity.Motherboard;
import com.onlinepcshop.core.domain.entity.MotherboardPcieInterface;
import com.onlinepcshop.core.domain.entity.MotherboardStorageInterface;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MotherboardUseCase {
    /***
     *  Create and persist an agent
     *
     * @param motherboard newly created motherboard
     * @return Valid user object with id
     */
    Motherboard createMotherboard(Motherboard motherboard);

    /***
     *  Update motherboard data fields
     * @param motherboard must be a valid motherboard object with valid id
     * @return Updated motherboard object
     */
    Motherboard updateMotherboard(Motherboard motherboard);

    /***
     *
     * @return List of all motherboards
     */
    List<Motherboard> findAllMotherboards();


    /***
     * @param motherboardId valid motherboard UUID
     * @return Motherboard with provided agentId if one exists
     */
    Optional<Motherboard> findMotherboardById(UUID motherboardId);

    /***
     * Delete motherboard with specified id
     * @param id must be a valid
     */
    void deleteMotherboard(UUID id);

    /***
     * Assigns a PcieInterface to Motherboard
     * @param pcieInterfaceId valid UUID of an exising PcieInterface
     * @param motherboardId valid UUID of an existing Motherboard object
     */
    MotherboardPcieInterface assignPcieInterface(UUID pcieInterfaceId, UUID motherboardId);


    /***
     * Unassign a PcieInterface from Motherboard
     * @param pcieInterfaceId valid UUID of an exising PcieInterface
     * @param motherboardId valid UUID of an existing Motherboard object
     */
    void unassignPcieInterface(UUID pcieInterfaceId, UUID motherboardId);

    /***
     * Assigns a StorageInterface to Motherboard
     * @param storageInterfaceId valid UUID of an exising StorageInterface
     * @param motherboardId valid UUID of an existing Motherboard object
     */
    MotherboardStorageInterface assignStorageInterface(UUID storageInterfaceId, UUID motherboardId);


    /***
     * Unassign a StorageInterface from Motherboard
     * @param storageInterfaceId valid UUID of an exising StorageInterface
     * @param motherboardId valid UUID of an existing Motherboard object
     */
    void unassignStorageInterface(UUID storageInterfaceId, UUID motherboardId);
}
