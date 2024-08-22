package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.RamDao;
import com.onlinepcshop.adapters.persistance.mapper.RamMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.RamJpaRepository;
import com.onlinepcshop.core.domain.entity.Ram;
import com.onlinepcshop.core.repository.RamRepository;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public class RamRepositoryImpl implements RamRepository {
    private final RamJpaRepository ramJpaRepository;

    @Override
    public List<Ram> findAllRams() {
        return RamMapperDB.INSTANCE.ramDaoListToRamList(ramJpaRepository.findAll());
    }

    @Override
    public Optional<Ram> findById(UUID ramId) {
        Ram ram = RamMapperDB.INSTANCE.ramDaoToRam(ramJpaRepository.findById(ramId).orElse(null));
        return Optional.ofNullable(ram);
    }

    @Override
    public Ram saveRam(Ram ram) {
        RamDao ramDao = RamMapperDB.INSTANCE.ramToRamDao(ram);
        return RamMapperDB.INSTANCE.ramDaoToRam(ramJpaRepository.save(ramDao));
    }

    @Override
    public void deleteRam(UUID id) {
        ramJpaRepository.deleteById(id);
    }
}
