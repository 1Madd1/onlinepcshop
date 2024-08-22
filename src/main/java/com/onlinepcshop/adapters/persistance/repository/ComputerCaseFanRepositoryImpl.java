package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.ComputerCaseFanDao;
import com.onlinepcshop.adapters.persistance.mapper.ComputerCaseFanMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.ComputerCaseFanJpaRepository;
import com.onlinepcshop.core.domain.entity.ComputerCaseFan;
import com.onlinepcshop.core.repository.ComputerCaseFanRepository;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public class ComputerCaseFanRepositoryImpl implements ComputerCaseFanRepository {
    private final ComputerCaseFanJpaRepository computerCaseFanJpaRepository;

    @Override
    public List<ComputerCaseFan> findAllComputerCaseFans() {
        return ComputerCaseFanMapperDB.INSTANCE.computerCaseFanDaoListToComputerCaseFanList(computerCaseFanJpaRepository.findAll());
    }

    @Override
    public Optional<ComputerCaseFan> findById(UUID computerCaseFanId) {
        ComputerCaseFan computerCaseFan = ComputerCaseFanMapperDB.INSTANCE.computerCaseFanDaoToComputerCaseFan(computerCaseFanJpaRepository.findById(computerCaseFanId).orElse(null));
        return Optional.ofNullable(computerCaseFan);
    }

    @Override
    public ComputerCaseFan saveComputerCaseFan(ComputerCaseFan computerCaseFan) {
        ComputerCaseFanDao computerCaseFanDao = ComputerCaseFanMapperDB.INSTANCE.computerCaseFanToComputerCaseFanDao(computerCaseFan);
        return ComputerCaseFanMapperDB.INSTANCE.computerCaseFanDaoToComputerCaseFan(computerCaseFanJpaRepository.save(computerCaseFanDao));
    }

    @Override
    public void deleteComputerCaseFan(UUID id) {
        computerCaseFanJpaRepository.deleteById(id);
    }
}
