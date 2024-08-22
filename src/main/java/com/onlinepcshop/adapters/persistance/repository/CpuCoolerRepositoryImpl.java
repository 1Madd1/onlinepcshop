package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.CoolerDao;
import com.onlinepcshop.adapters.persistance.mapper.CoolerMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.CpuCoolerJpaRepository;
import com.onlinepcshop.core.domain.entity.Cooler;
import com.onlinepcshop.core.repository.CpuCoolerRepository;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public class CpuCoolerRepositoryImpl implements CpuCoolerRepository {
    private final CpuCoolerJpaRepository cpuCoolerJpaRepository;

    @Override
    public List<Cooler> findAllCpuCoolers() {
        return CoolerMapperDB.INSTANCE.cpuCoolerDaoListToCpuCoolerList(cpuCoolerJpaRepository.findAll());
    }

    @Override
    public Optional<Cooler> findById(UUID cpuCoolerId) {
        Cooler cooler = CoolerMapperDB.INSTANCE.cpuCoolerDaoToCpuCooler(cpuCoolerJpaRepository.findById(cpuCoolerId).orElse(null));
        return Optional.ofNullable(cooler);
    }

    @Override
    public Cooler saveCpuCooler(Cooler cooler) {
        CoolerDao coolerDao = CoolerMapperDB.INSTANCE.cpuCoolerToCpuCoolerDao(cooler);
        return CoolerMapperDB.INSTANCE.cpuCoolerDaoToCpuCooler(cpuCoolerJpaRepository.save(coolerDao));
    }

    @Override
    public void deleteCpuCooler(UUID id) {
        cpuCoolerJpaRepository.deleteById(id);
    }
}
