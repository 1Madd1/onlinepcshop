package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.PowerSupplyDao;
import com.onlinepcshop.adapters.persistance.mapper.PowerSupplyMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.PowerSupplyJpaRepository;
import com.onlinepcshop.core.domain.entity.PowerSupply;
import com.onlinepcshop.core.repository.PowerSupplyRepository;
import lombok.Builder;

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
}
