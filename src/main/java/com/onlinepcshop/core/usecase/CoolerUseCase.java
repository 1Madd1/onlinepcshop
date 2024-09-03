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
     * @param coolerId valid cooler UUID
     * @return Cooler with provided agentId if one exists
     */
    Optional<Cooler> findCoolerById(UUID coolerId);

    /***
     * Delete cooler with specified id
     * @param id must be a valid
     */
    void deleteCooler(UUID id);
}
