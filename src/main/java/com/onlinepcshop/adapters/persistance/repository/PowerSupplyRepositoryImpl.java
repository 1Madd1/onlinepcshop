package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.PowerSupplyDao;
import com.onlinepcshop.adapters.persistance.mapper.PowerSupplyMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.PowerSupplyJpaRepository;
import com.onlinepcshop.core.domain.entity.PowerSupply;
import com.onlinepcshop.core.repository.PowerSupplyRepository;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public class PowerSupplyRepositoryImpl implements PowerSupplyRepository {
    private final PowerSupplyJpaRepository powerSupplyJpaRepository;

    @Override
    public List<PowerSupply> findAllPowerSupplys() {
        return PowerSupplyMapperDB.INSTANCE.powerSupplyDaoListToPowerSupplyList(powerSupplyJpaRepository.findAll());
    }

    @Override
    public List<PowerSupply> findAllAvailablePowerSupplys() {
        return PowerSupplyMapperDB.INSTANCE.powerSupplyDaoListToPowerSupplyList(powerSupplyJpaRepository.findAllByQuantityGreaterThan(0));
    }

    @Override
    public Optional<PowerSupply> findById(UUID powerSupplyId) {
        PowerSupply powerSupply = PowerSupplyMapperDB.INSTANCE.powerSupplyDaoToPowerSupply(powerSupplyJpaRepository.findById(powerSupplyId).orElse(null));
        return Optional.ofNullable(powerSupply);
    }

    @Override
    public PowerSupply savePowerSupply(PowerSupply powerSupply) {
        PowerSupplyDao powerSupplyDao = PowerSupplyMapperDB.INSTANCE.powerSupplyToPowerSupplyDao(powerSupply);
        return PowerSupplyMapperDB.INSTANCE.powerSupplyDaoToPowerSupply(powerSupplyJpaRepository.save(powerSupplyDao));
    }

    @Override
    public void deletePowerSupply(UUID id) {
        powerSupplyJpaRepository.deleteById(id);
    }

    @Override
    public List<PowerSupply> findAllPowerSupplysByMaxPriceAndMinWattage(Double maxPrice, Integer minWattage) {
        return PowerSupplyMapperDB.INSTANCE.powerSupplyDaoListToPowerSupplyList(powerSupplyJpaRepository.findByPriceLessThanEqualAndWattageGreaterThanEqualAndQuantityGreaterThan(maxPrice, minWattage, 0));
    }

    @Override
    public List<PowerSupply> findAllByHavingSaleAndByComponentName(String componentName) {
        return PowerSupplyMapperDB.INSTANCE.powerSupplyDaoListToPowerSupplyList(powerSupplyJpaRepository.findBySaleTypeNotNullAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(componentName, 0));
    }

    @Override
    public List<PowerSupply> searchByComponentName(String name) {
        return PowerSupplyMapperDB.INSTANCE.powerSupplyDaoListToPowerSupplyList(powerSupplyJpaRepository.findByComponentNameContainingIgnoreCaseAndQuantityGreaterThan(name, 0));
    }

    @Override
    public List<PowerSupply> findAllNewPowerSuppliesByComponentName(String componentName) {
        LocalDate localDate = LocalDate.now().minusMonths(1);
        return PowerSupplyMapperDB.INSTANCE.powerSupplyDaoListToPowerSupplyList(powerSupplyJpaRepository.findByDateOfCreationAfterAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(localDate, componentName, 0));
    }
}
