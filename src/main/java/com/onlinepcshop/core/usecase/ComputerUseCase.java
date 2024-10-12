package com.onlinepcshop.core.usecase;

import com.onlinepcshop.core.domain.entity.Computer;
import com.onlinepcshop.core.domain.entity.ComputerCaseFan;
import com.onlinepcshop.core.domain.entity.ComputerRam;
import com.onlinepcshop.core.domain.entity.ComputerStorage;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ComputerUseCase {
    /***
     *  Create and persist an agent
     *
     * @param computer newly created computer
     * @return Valid user object with id
     */
    Computer createComputer(Computer computer);

    /***
     *  Update computer data fields
     * @param computer must be a valid computer object with valid id
     * @return Updated computer object
     */
    Computer updateComputer(Computer computer);

    /***
     *
     * @return List of all computers
     */
    List<Computer> findAllComputers();


    /***
     * @param computerId valid computer UUID
     * @return Computer with provided agentId if one exists
     */
    Optional<Computer> findComputerById(UUID computerId);

    /***
     * Delete computer with specified id
     * @param id must be a valid
     */
    void deleteComputer(UUID id);

    /**
     * Assigns a Ram to existing Computer
     * @param ramId - valid UUID of an exising Ram
     * @param computerId - valid UUID of an exising Computer
     * @param quantity - amount of Ram being assigned to existing Computer
     */
    ComputerRam assignRam(UUID ramId, UUID computerId, Integer quantity);

    /***
     * Unassign a Ram from existing Computer
     * @param ramId valid UUID of an exising Ram object
     * @param computerId valid UUID of an existing Computer object
     */
    void unassignRam(UUID ramId, UUID computerId);

    /**
     * Assigns a Storage to existing Computer
     * @param storageId - valid UUID of an exising Storage
     * @param computerId - valid UUID of an exising Computer
     * @param quantity - amount of Storage being assigned to existing Computer
     */
    ComputerStorage assignStorage(UUID storageId, UUID computerId, Integer quantity);

    /***
     * Unassign a Storage from existing Computer
     * @param storageId valid UUID of an exising Storage object
     * @param computerId valid UUID of an existing Computer object
     */
    void unassignStorage(UUID storageId, UUID computerId);

    /**
     * Assigns a Case Fan to existing Computer
     * @param caseFanId - valid UUID of an exising Case Fan
     * @param computerId - valid UUID of an exising Computer
     * @param quantity - amount of Case Fan being assigned to existing Computer
     */
    ComputerCaseFan assignCaseFan(UUID caseFanId, UUID computerId, Integer quantity);

    /***
     * Unassign a Case Fan from existing Computer
     * @param caseFanId valid UUID of an exising Case Fan object
     * @param computerId valid UUID of an existing Computer object
     */
    void unassignCaseFan(UUID caseFanId, UUID computerId);
}
