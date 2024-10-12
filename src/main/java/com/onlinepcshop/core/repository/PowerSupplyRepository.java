package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.PowerSupply;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PowerSupplyRepository {
    List<PowerSupply> findAllPowerSupplys();

    Optional<PowerSupply> findById(UUID powerSupplyId);

    PowerSupply savePowerSupply(PowerSupply powerSupply);

    void deletePowerSupply(UUID id);

    List<PowerSupply> findAllPowerSupplysByMaxPriceAndMinWattage(Double maxPrice, Integer minWattage);
}
