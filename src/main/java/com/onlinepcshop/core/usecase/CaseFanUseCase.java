package com.onlinepcshop.core.usecase;

import com.onlinepcshop.core.domain.entity.CaseFan;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CaseFanUseCase {
    /***
     *  Create and persist an agent
     *
     * @param caseFan newly created case fan
     * @return Valid user object with id
     */
    CaseFan createCaseFan(CaseFan caseFan);

    /***
     *  Update caseFan data fields
     * @param caseFan must be a valid case fan object with valid id
     * @return Updated caseFan object
     */
    CaseFan updateCaseFan(CaseFan caseFan);

    /***
     *
     * @return List of all case fans
     */
    List<CaseFan> findAllCaseFans();

    /***
     *
     * @return List of all case fans that have quantity larger than 0
     */
    List<CaseFan> findAllAvailableCaseFans();


    /***
     * @param caseFanId valid caseFan UUID
     * @return CaseFan with provided agentId if one exists
     */
    Optional<CaseFan> findCaseFanById(UUID caseFanId);

    /***
     * Delete case fan with specified id
     * @param id must be a valid
     */
    void deleteCaseFan(UUID id);

    /**
     * @param maxPrice - max. price of case fan
     * @return - List of all case fans that are equal or below max. price
     */
    List<CaseFan> findAllCaseFansByMaxPrice(Double maxPrice);

    /**
     * @param computerId - valid UUID of existing computer
     * @return - List of all case fans that have the same computer id
     */
    List<CaseFan> findAllCaseFansByComputerId(UUID computerId);

    /**
     * @param caseFanId  - valid UUID of existing case fan
     * @param computerId - valid UUID of existing computer
     * @return - amount of case fans that are assigned to the computer
     */
    Integer findQuantityByCaseFanIdAndComputerId(UUID caseFanId, UUID computerId);

    /**
     * @param caseFanId - valid UUID of existing case fan
     * @return - average case fan rating based on given case fan id
     */
    Double getCaseFanAverageRating(UUID caseFanId);

    /**
     * @param name - valid component name of existing case fan
     * @return - List of all case fans that include given component name
     */
    List<CaseFan> searchByName(String name);
}
