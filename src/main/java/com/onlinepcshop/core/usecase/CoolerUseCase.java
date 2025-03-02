package com.onlinepcshop.core.usecase;

import com.onlinepcshop.core.domain.entity.Cooler;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CoolerUseCase {
    /***
     *  Create and persist an agent
     *
     * @param cooler newly created cooler
     * @return Valid user object with id
     */
    Cooler createCooler(Cooler cooler);

    /***
     *  Update cooler data fields
     * @param cooler must be a valid cooler object with valid id
     * @return Updated cooler object
     */
    Cooler updateCooler(Cooler cooler);

    /***
     *
     * @return List of all coolers
     */
    List<Cooler> findAllCoolers();

    /***
     *
     * @return List of all coolers that have quantity greater than 0
     */
    List<Cooler> findAllAvailableCoolers();


    /***
     * @param coolerId valid cooler UUID
     * @return Cooler with provided agentId if one exists
     */
    Optional<Cooler> findCoolerById(UUID coolerId);

    /***
     * Delete cooler with specified id
     * @param id must be a valid
     */
    void deleteCooler(UUID id);

    /**
     * @param maxPrice - max. price of cooler
     * @return - List of all coolers that are equal or below max. price
     */
    List<Cooler> findAllCoolersByMaxPrice(Double maxPrice);

    /**
     * @param name - valid component name of existing cooler
     * @return - List of all computers that include given component name
     */
    List<Cooler> searchByName(String name);

    /**
     * @param coolerId - valid UUID of existing cooler
     * @return - average cooler rating based on given cooler id
     */
    Double getCoolerAverageRating(UUID coolerId);
}
