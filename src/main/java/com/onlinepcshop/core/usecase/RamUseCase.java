package com.onlinepcshop.core.usecase;

import com.onlinepcshop.core.domain.entity.Ram;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RamUseCase {
    /***
     *  Create and persist an agent
     *
     * @param ram newly created ram
     * @return Valid user object with id
     */
    Ram createRam(Ram ram);

    /***
     *  Update ram data fields
     * @param ram must be a valid ram object with valid id
     * @return Updated ram object
     */
    Ram updateRam(Ram ram);

    /***
     *
     * @return List of all rams
     */
    List<Ram> findAllRams();


    /***
     * @param ramId valid ram UUID
     * @return Ram with provided agentId if one exists
     */
    Optional<Ram> findRamById(UUID ramId);

    /***
     * Delete ram with specified id
     * @param id must be a valid
     */
    void deleteRam(UUID id);

    /**
     *
     * @param maxPrice - max. allowed price of searched ram
     * @param memoryType - memory type of searched ram
     * @return - List of all rams that are equal or below max. price and are of same memory type
     */
    List<Ram> findAllRamsByMaxPriceAndMemoryType(Double maxPrice, String memoryType);

    /**
     *
     * @param computerId - valid UUID of existing computer
     * @return - List of all rams that have the same computer id
     */
    List<Ram> findAllRamsByComputerId(UUID computerId);

    /**
     *
     * @param ramId - valid UUID of existing ram
     * @param computerId - valid UUID of existing computer
     * @return - amount of rams that are assigned to the computer
     */
    Integer findQuantityByRamIdAndComputerId(UUID ramId, UUID computerId);
}
