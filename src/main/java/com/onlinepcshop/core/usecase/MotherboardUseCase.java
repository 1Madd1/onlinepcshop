package com.onlinepcshop.core.usecase;

import com.onlinepcshop.core.domain.entity.*;

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
     *
     * @return List of all motherboards that have quantity greater than 0
     */
    List<Motherboard> findAllAvailableMotherboards();


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
     * @param pcieInterfaceId valid UUID of an exising PcieInterface object
     * @param motherboardId valid UUID of an existing Motherboard object
     */
    MotherboardPcieInterface assignPcieInterface(UUID pcieInterfaceId, UUID motherboardId);


    /***
     * Unassign a PcieInterface from Motherboard
     * @param pcieInterfaceId valid UUID of an exising PcieInterface object
     * @param motherboardId valid UUID of an existing Motherboard object
     */
    void unassignPcieInterface(UUID pcieInterfaceId, UUID motherboardId);

    /***
     * Assigns a StorageInterface to Motherboard
     * @param storageInterfaceId valid UUID of an exising StorageInterface object
     * @param motherboardId valid UUID of an existing Motherboard object
     */
    MotherboardStorageInterface assignStorageInterface(UUID storageInterfaceId, UUID motherboardId);


    /***
     * Unassign a StorageInterface from Motherboard
     * @param storageInterfaceId valid UUID of an exising StorageInterface object
     * @param motherboardId valid UUID of an existing Motherboard object
     */
    void unassignStorageInterface(UUID storageInterfaceId, UUID motherboardId);

    /**
     * @param maxPrice              - max. allowed price of searched motherboard
     * @param storageInterfaceLimit - max. number of motherboard's storage interfaces
     * @return - List of all motherboards that are equal or below max. price and max. number of storage interfaces
     */
    List<Motherboard> findAllMotherboardsByMaxPriceAndByStorageInterfaceLimit(Double maxPrice, Integer storageInterfaceLimit);

    /**
     * @param name - valid component name of existing motherboard
     * @return - List of all computers that include given component name
     */
    List<Motherboard> searchByName(String name);

    /**
     * @param motherboardId - valid motherboard UUID
     * @return - list of all PCIe interfaces that are assigned to given motherboard id
     */
    List<PcieInterface> getAllPcieInterfacesByMotherboardId(UUID motherboardId);

    /**
     * @param motherboardId - valid motherboard UUID
     * @return - list of all Storage interfaces that are assigned to given motherboard id
     */
    List<StorageInterface> getAllStorageInterfacesByMotherboardId(UUID motherboardId);

    /**
     * @param motherboardId - valid UUID of existing motherboard
     * @return - average motherboard rating based on given motherboard id
     */
    Double getMotherboardAverageRating(UUID motherboardId);
}
