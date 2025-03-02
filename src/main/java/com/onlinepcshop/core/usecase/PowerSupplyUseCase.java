package com.onlinepcshop.core.usecase;

import com.onlinepcshop.core.domain.entity.PowerSupply;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PowerSupplyUseCase {
    /***
     *  Create and persist an agent
     *
     * @param powerSupply newly created power supply
     * @return Valid user object with id
     */
    PowerSupply createPowerSupply(PowerSupply powerSupply);

    /***
     *  Update power supply data fields
     * @param powerSupply must be a valid power supply object with valid id
     * @return Updated powerSupply object
     */
    PowerSupply updatePowerSupply(PowerSupply powerSupply);

    /***
     *
     * @return List of all powerSupplys
     */
    List<PowerSupply> findAllPowerSupplys();

    /***
     *
     * @return List of all powerSupplys that have quantity greater than 0
     */
    List<PowerSupply> findAllAvailablePowerSupplys();


    /***
     * @param powerSupplyId valid power supply UUID
     * @return PowerSupply with provided agentId if one exists
     */
    Optional<PowerSupply> findPowerSupplyById(UUID powerSupplyId);

    /***
     * Delete power supply with specified id
     * @param id must be a valid
     */
    void deletePowerSupply(UUID id);

    /**
     * @param maxPrice   - max. price of power supply
     * @param minWattage - min. needed wattage of power supply
     * @return - List of all power supplies that are equal or below max. price and are equal or above min. wattage
     */
    List<PowerSupply> findAllPowerSupplysByMaxPriceAndMinWattage(Double maxPrice, Integer minWattage);

    /**
     * @param name - valid component name of existing power supply
     * @return - List of all computers that include given component name
     */
    List<PowerSupply> searchByName(String name);

    /**
     * @param powerSupplyId - valid UUID of existing power supply id
     * @return - average power supply rating based on given power supply id
     */
    Double getPowerSupplyAverageRating(UUID powerSupplyId);
}
