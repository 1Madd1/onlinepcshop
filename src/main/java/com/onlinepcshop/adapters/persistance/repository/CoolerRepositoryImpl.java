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
    public List<Cooler> findAllCoolers() {
        return CoolerMapperDB.INSTANCE.coolerDaoListToCoolerList(coolerJpaRepository.findAll());
    }

    @Override
    public Optional<Cooler> findById(UUID coolerId) {
        Cooler cooler = CoolerMapperDB.INSTANCE.coolerDaoToCooler(coolerJpaRepository.findById(coolerId).orElse(null));
        return Optional.ofNullable(cooler);
    }

    @Override
    public Cooler saveCooler(Cooler cooler) {
        CoolerDao coolerDao = CoolerMapperDB.INSTANCE.coolerToCoolerDao(cooler);
        return CoolerMapperDB.INSTANCE.coolerDaoToCooler(coolerJpaRepository.save(coolerDao));
    }

    @Override
    public void deleteCooler(UUID id) {
        coolerJpaRepository.deleteById(id);
    }

    @Override
    public List<Cooler> findAllCoolersByMaxPrice(Double maxPrice) {
        return CoolerMapperDB.INSTANCE.coolerDaoListToCoolerList(coolerJpaRepository.findByPriceLessThanEqual(maxPrice));
    }
}
