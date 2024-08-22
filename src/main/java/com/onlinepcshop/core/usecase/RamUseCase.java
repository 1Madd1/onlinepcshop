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
}
