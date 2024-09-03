package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.CoolerDao;
import com.onlinepcshop.adapters.persistance.mapper.CoolerMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.CoolerJpaRepository;
import com.onlinepcshop.core.domain.entity.Cooler;
import com.onlinepcshop.core.repository.CoolerRepository;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public class CoolerRepositoryImpl implements CoolerRepository {
    private final CoolerJpaRepository coolerJpaRepository;

    @Override
    public List<Cooler> findAllCpuCoolers() {
        return CoolerMapperDB.INSTANCE.cpuCoolerDaoListToCpuCoolerList(coolerJpaRepository.findAll());
    }

    @Override
    public Optional<Cooler> findById(UUID cpuCoolerId) {
        Cooler cooler = CoolerMapperDB.INSTANCE.cpuCoolerDaoToCpuCooler(coolerJpaRepository.findById(cpuCoolerId).orElse(null));
        return Optional.ofNullable(cooler);
    }

    @Override
    public Cooler saveCpuCooler(Cooler cooler) {
        CoolerDao coolerDao = CoolerMapperDB.INSTANCE.cpuCoolerToCpuCoolerDao(cooler);
        return CoolerMapperDB.INSTANCE.cpuCoolerDaoToCpuCooler(coolerJpaRepository.save(coolerDao));
    }

    @Override
    public void deleteCpuCooler(UUID id) {
        coolerJpaRepository.deleteById(id);
    }
}
