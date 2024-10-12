package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.Computer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ComputerRepository {
    List<Computer> findAllComputers();

    Optional<Computer> findById(UUID cpuComputerId);

    Computer saveComputer(Computer computer);

    void deleteComputer(UUID id);
}
