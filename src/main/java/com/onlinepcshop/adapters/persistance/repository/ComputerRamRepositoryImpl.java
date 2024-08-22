package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.ComputerRamDao;
import com.onlinepcshop.adapters.persistance.mapper.ComputerRamMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.ComputerRamJpaRepository;
import com.onlinepcshop.core.domain.entity.ComputerRam;
import com.onlinepcshop.core.repository.ComputerRamRepository;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public class ComputerRamRepositoryImpl implements ComputerRamRepository {
    private final ComputerRamJpaRepository computerRamJpaRepository;

    @Override
    public List<ComputerRam> findAllComputerRams() {
        return ComputerRamMapperDB.INSTANCE.computerRamDaoListToComputerRamList(computerRamJpaRepository.findAll());
    }

    @Override
    public Optional<ComputerRam> findById(UUID computerRamId) {
        ComputerRam computerRam = ComputerRamMapperDB.INSTANCE.computerRamDaoToComputerRam(computerRamJpaRepository.findById(computerRamId).orElse(null));
        return Optional.ofNullable(computerRam);
    }

    @Override
    public ComputerRam saveComputerRam(ComputerRam computerRam) {
        ComputerRamDao computerRamDao = ComputerRamMapperDB.INSTANCE.computerRamToComputerRamDao(computerRam);
        return ComputerRamMapperDB.INSTANCE.computerRamDaoToComputerRam(computerRamJpaRepository.save(computerRamDao));
    }

    @Override
    public void deleteComputerRam(UUID id) {
        computerRamJpaRepository.deleteById(id);
    }
}
