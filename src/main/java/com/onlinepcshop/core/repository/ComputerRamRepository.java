package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.ComputerRam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ComputerRamRepository {
    List<ComputerRam> findAllComputerRams();

    Optional<ComputerRam> findById(UUID computerRamId);

    ComputerRam saveComputerRam(ComputerRam computerRam);

    void deleteComputerRam(UUID id);
}
