package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.CaseFanDao;
import com.onlinepcshop.adapters.persistance.mapper.CaseFanMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.CaseFanJpaRepository;
import com.onlinepcshop.core.domain.entity.CaseFan;
import com.onlinepcshop.core.repository.CaseFanRepository;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public class CaseFanRepositoryImpl implements CaseFanRepository {
    private final CaseFanJpaRepository caseFanJpaRepository;

    @Override
    public List<CaseFan> findAllCaseFans() {
        return CaseFanMapperDB.INSTANCE.caseFanDaoListToCaseFanList(caseFanJpaRepository.findAll());
    }

    @Override
    public Optional<CaseFan> findById(UUID caseFanId) {
        CaseFan caseFan = CaseFanMapperDB.INSTANCE.caseFanDaoToCaseFan(caseFanJpaRepository.findById(caseFanId).orElse(null));
        return Optional.ofNullable(caseFan);
    }

    @Override
    public CaseFan saveCaseFan(CaseFan caseFan) {
        CaseFanDao caseFanDao = CaseFanMapperDB.INSTANCE.caseFanToCaseFanDao(caseFan);
        return CaseFanMapperDB.INSTANCE.caseFanDaoToCaseFan(caseFanJpaRepository.save(caseFanDao));
    }

    @Override
    public void deleteCaseFan(UUID id) {
        caseFanJpaRepository.deleteById(id);
    }

    @Override
    public List<CaseFan> findAllCaseFansByMaxPrice(Double maxPrice) {
        return CaseFanMapperDB.INSTANCE.caseFanDaoListToCaseFanList(caseFanJpaRepository.findByPriceLessThanEqual(maxPrice));
    }
}
