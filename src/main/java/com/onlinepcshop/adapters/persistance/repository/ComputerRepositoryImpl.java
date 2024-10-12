package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.ComputerDao;
import com.onlinepcshop.adapters.persistance.mapper.ComputerMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.ComputerJpaRepository;
import com.onlinepcshop.core.domain.entity.Computer;
import com.onlinepcshop.core.repository.ComputerRepository;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public class ComputerRepositoryImpl implements ComputerRepository {
    private final ComputerJpaRepository computerJpaRepository;

    @Override
    public List<Computer> findAllComputers() {
        return ComputerMapperDB.INSTANCE.computerDaoListToComputerList(computerJpaRepository.findAll());
    }

    @Override
    public Optional<Computer> findById(UUID computerId) {
        Computer computer = ComputerMapperDB.INSTANCE.computerDaoToComputer(computerJpaRepository.findById(computerId).orElse(null));
        return Optional.ofNullable(computer);
    }

    @Override
    public Computer saveComputer(Computer computer) {
        ComputerDao computerDao = ComputerMapperDB.INSTANCE.computerToComputerDao(computer);
        return ComputerMapperDB.INSTANCE.computerDaoToComputer(computerJpaRepository.save(computerDao));
    }

    @Override
    public void deleteComputer(UUID id) {
        computerJpaRepository.deleteById(id);
    }
}
